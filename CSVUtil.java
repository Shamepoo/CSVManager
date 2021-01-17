import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVUtil {

    public static final String QUOTATION_MARK = "\"";
    public static final String NONE = "";
    private static final String COMMA = ",{1}\\s{0}";

    public static <T> CSVInfo<T> parseCSVFile(String filePath, Class<T> clazz) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new FileNotFoundException("File is not exist");
        }
        Field[] declaredFields = clazz.getDeclaredFields();

        List<T> collect = Files.readAllLines(path).stream()
                .map(e -> e.replaceAll(QUOTATION_MARK, NONE))
                .map(e -> {
                    T instance = null;
                    try {
                        instance = clazz.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException exception) {
                        exception.printStackTrace();
                    }
                    e = e.replaceAll(", ", "¿");

                    String[] split = Arrays
                            .stream(e.split(COMMA, -1))
                            .map(v -> v.replaceAll("¿", ", "))
                            .toArray(String[]::new);

                    e = e.replaceAll("¿", ", ");
                    for (int i = 0; i < split.length; i++) {
                        try {
                            Field field = declaredFields[i];
                            field.setAccessible(true);
                            field.set(instance, split[i]);
                        } catch (IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                    return instance;
                }).collect(Collectors.toList());


        return CSVInfo
                .<T>builder()
                .path(filePath)
                .colNumber(declaredFields.length)
                .rowNumber(collect.size())
                .data(collect)
                .build();
    }

    public static <T> void writeCSVFile(CSVInfo<T> csvInfo) throws IOException {
        Path path = Paths.get(csvInfo.getPath());
        StringBuffer stringBuffer = new StringBuffer();
        csvInfo.getData().forEach(e -> stringBuffer.append(e.toString()));

        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        Files.write(path, stringBuffer.toString().getBytes(StandardCharsets.UTF_8));
    }

}
