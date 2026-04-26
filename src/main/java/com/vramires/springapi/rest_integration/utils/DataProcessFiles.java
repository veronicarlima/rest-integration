package com.vramires.springapi.rest_integration.utils;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.MappingIterator;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import java.util.List;

@Slf4j
@Service
public class DataProcessFiles {

    public static String APPLICATION_PROPERTIES = "application.properties";
    public static final String CSV_FILE_NAME_KEY = "csv.file.name";
    public static final String DEFAULT_FILE_NAME = "file.csv";

    public <T> List<T> loadObjectList(Class<T> type, String fileName){
        try {
            CsvSchema fileSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(CSV_FILE_NAME_KEY).getFile();

            MappingIterator<T> readValues =
                    mapper.reader(type).with(fileSchema).readValue(file);
            return readValues.readAll();

        } catch (Exception e) {
            log.error("Error occured to read the file "+ fileName, e);
            return Collections.emptyList();
        }

    }
}
