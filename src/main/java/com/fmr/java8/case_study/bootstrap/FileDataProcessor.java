package com.fmr.java8.case_study.bootstrap;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fmr.java8.case_study.domain.Address;
import com.fmr.java8.case_study.domain.Trader;
import com.fmr.java8.case_study.model.FileData;
import com.fmr.java8.case_study.service.TraderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FileDataProcessor {

    private final Logger logger = LoggerFactory.getLogger(FileDataProcessor.class);

    @Autowired
    TraderService traderService;

    @Bean
    public CommandLineRunner loadCustomerData() throws IOException {
        return args -> {
            logger.info("Read info from CSV file");
            final ObjectMapper mapper = new CsvMapper();
            final CsvSchema schema = CsvSchema.emptySchema()
                                         // use first row as header; otherwise defaults are fine
                                         .withHeader()
                                         // let's do pipe-delimited, not comma-delimited
                                         .withColumnSeparator('|');

            final MappingIterator<FileData> fileData = mapper.readerFor(FileData.class)
                                                           .with(schema)
                                                           .readValues(new ClassPathResource("customer_info.csv").getFile());

            // Either read them all one by one (streaming)
            while (fileData.hasNextValue()) {
                final FileData fd = fileData.nextValue();
                logger.trace("---->" + fd.toString());
                try {
                    Double d = Double.valueOf(fd.getMoney());
                    Address ad = new Address(fd.getStreet(), fd.getCity(), fd.getZip(), fd.getState(), "USA");
                    Trader td = new Trader(fd.getFirstName(), fd.getLastName(), fd.getEmail(), fd.getPhoneNumber(), ad, fd.getAccountNumber(), d, d, null, null);
                    traderService.addTrader(td);
                } catch (Exception e) {
                    // do Nothing -- Skip to next record
                    logger.warn(">>>>>>>>> Not able to save data for " + fd.getFirstName() + " and Error is " + e.getMessage());
                }
            }
            logger.info("CSV File Successfully loaded into database");
        };
    }
}
