package CaseStudy_Module2.Commons;

import CaseStudy_Module2.Models.Customer;
import CaseStudy_Module2.Models.House;
import CaseStudy_Module2.Models.Room;
import CaseStudy_Module2.Models.Villa;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncWirteAndReadFileCSV {
    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';
    private static final String pathVilla = "src/CaseStudy_Module2/Data/Villa.csv";
    private static final String pathHouse = "src/CaseStudy_Module2/Data/House.csv";
    private static final String pathRoom = "src/CaseStudy_Module2/Data/Room.csv";
    private static final String pathCustomer = "src/CaseStudy_Module2/Data/Customer.csv";

    private static String[] headerRecordVilla = new String[]{
            "id", "nameService", "areaUsed", "rentalCosts", "maxNumberOfPeople", "typeRent", "roomStandard", "convenient", "areaPool", "numberOfFloors"
    };
    private static String[] headerRecordHouse = new String[]{
            "id", "nameService", "areaUsed", "rentalCosts", "maxNumberOfPeople", "typeRent", "roomStandard", "convenient", "numberOfFloors"
    };
    private static String[] headerRecordRoom = new String[]{
            "id", "nameService", "areaUsed", "rentalCosts", "maxNumberOfPeople", "typeRent", "freeService"
    };
    private static String[] headerRecordCustomer = new String[]{
            "nameCustomer", "birthdayCustomer", "sexCustomer", "idCardCustomer", "phoneNumber", "emailCustomer", "typeCustomer", "addressCustomer"
    };
    private static final int NUM_OF_LNE_SKIP = 1;

    public static void writeVillaToFileCSV(ArrayList<Villa> arrayList) {
        try (Writer writer = new FileWriter(pathVilla);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.RFC4180_LINE_END
             )) {
            csvWriter.writeNext(headerRecordVilla);
            for (Villa villa : arrayList) {
                csvWriter.writeNext(new String[]{
                        villa.getId(),
                        villa.getNameService(),
                        String.valueOf(villa.getAreaUsed()),
                        String.valueOf(villa.getRentalCosts()),
                        String.valueOf(villa.getMaxNumberOfPeople()),
                        villa.getTypeRent(),
                        villa.getRoomStandard(),
                        villa.getConvenient(),
                        String.valueOf(villa.getAreaPool()),
                        String.valueOf(villa.getNumberOfFloors())
                });
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeHouseToFileCSV(ArrayList<House> arrayList) {
        try (Writer writer = new FileWriter(pathHouse);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.RFC4180_LINE_END
             )) {
            csvWriter.writeNext(headerRecordVilla);
            for (House house : arrayList) {
                csvWriter.writeNext(new String[]{
                        house.getId(),
                        house.getNameService(),
                        String.valueOf(house.getAreaUsed()),
                        String.valueOf(house.getRentalCosts()),
                        String.valueOf(house.getMaxNumberOfPeople()),
                        house.getTypeRent(),
                        house.getRoomStandard(),
                        house.getConvenient(),
                        String.valueOf(house.getNumberOfFloors())
                });
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeRoomToFileCSV(ArrayList<Room> arrayList) {
        try (Writer writer = new FileWriter(pathRoom);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.RFC4180_LINE_END
             )) {
            csvWriter.writeNext(headerRecordRoom);
            for (Room room : arrayList) {
                csvWriter.writeNext(new String[]{
                        room.getId(),
                        room.getNameService(),
                        String.valueOf(room.getAreaUsed()),
                        String.valueOf(room.getRentalCosts()),
                        String.valueOf(room.getMaxNumberOfPeople()),
                        room.getTypeRent(),
                        String.valueOf(room.getFreeService())
                });
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeCustomerToFileCSV(ArrayList<Customer> arrayList) {
        try (Writer writer = new FileWriter(pathCustomer);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.RFC4180_LINE_END
             )) {
            csvWriter.writeNext(headerRecordCustomer);
            for (Customer customer : arrayList) {
                csvWriter.writeNext(new String[]{
                        customer.getNameCustomer(),
                        String.valueOf(customer.getBirthdayCustomer()),
                        customer.getSexCustomer(),
                        String.valueOf(customer.getIdCardCustomer()),
                        String.valueOf(customer.getPhoneNumber()),
                        customer.getEmailCustomer(),
                        customer.getTypeCustomer(),
                        customer.getAddressCustomer()
                });
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //function get list Villa from file csv
    public static ArrayList<Villa> getVillaFromCSV() {
        Path path = Paths.get(pathVilla);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(pathVilla);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());

            }
        }
        ColumnPositionMappingStrategy<Villa> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Villa.class);
        strategy.setColumnMapping(headerRecordVilla);
        CsvToBean<Villa> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Villa>(new FileReader(pathVilla))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LNE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return (ArrayList<Villa>) csvToBean.parse();
    }

    //function get list House from file csv
    public static ArrayList<House> getHouseFromCSV() {
        Path path = Paths.get(pathHouse);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(pathHouse);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());

            }
        }
        ColumnPositionMappingStrategy<House> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(House.class);
        strategy.setColumnMapping(headerRecordHouse);
        CsvToBean<House> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<House>(new FileReader(pathHouse))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LNE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return (ArrayList<House>) csvToBean.parse();
    }

    //function get list Room from file csv
    public static ArrayList<Room> getRoomFromCSV() {
        Path path = Paths.get(pathRoom);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(pathRoom);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());

            }
        }
        ColumnPositionMappingStrategy<Room> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Room.class);
        strategy.setColumnMapping(headerRecordRoom);
        CsvToBean<Room> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Room>(new FileReader(pathRoom))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LNE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return (ArrayList<Room>) csvToBean.parse();
    }

    public static ArrayList<Customer> getCustomerFromCSV() {
        Path path = Paths.get(pathCustomer);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(pathCustomer);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());

            }
        }
        ColumnPositionMappingStrategy<Customer> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Customer.class);
        strategy.setColumnMapping(headerRecordCustomer);
        CsvToBean<Customer> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader(pathCustomer))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LNE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return (ArrayList<Customer>) csvToBean.parse();
    }

}
