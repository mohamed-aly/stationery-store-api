package stationery.store.utilities;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Utils {


    public static Pageable pageable(Integer page, Integer pageSize, String sortBy){
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(sortBy).ascending());
        return pageable;
    }

    public static Pageable pageable(int page, int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return pageable;
    }




}
