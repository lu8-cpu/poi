package com.qfedu.day73_poi.poi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.day73_poi.dao.UserDao;
import com.qfedu.day73_poi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Controller
public class ImportController {
    @Autowired(required = false)
    UserDao userDao;
    private User user;
    @RequestMapping("/import")
    public String importExcel(@RequestParam MultipartFile upfile){


        // 获取上传文件的输入流对象
        try {
            InputStream inputStream = upfile.getInputStream();

            String filename = upfile.getOriginalFilename();

            List<Map<String, Object>> list = ExcelUtils.readExcel(filename, inputStream);
            //想把list转换为User类
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(list);
            // 将json格式的字符串转为指定类型的对象
            List<User> ulist = objectMapper.readValue(jsonStr, new TypeReference<List<User>>() {
            });

            System.out.println(ulist);
            //循环写入数据库
          for(int i = 0;i<ulist.size();i++){
              System.out.println(ulist.get(i));
                user = ulist.get(i);
              System.out.println(user);
                userDao.insert(user);
          }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/index.html";
    }
}






