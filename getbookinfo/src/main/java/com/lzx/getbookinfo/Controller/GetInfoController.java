package com.lzx.getbookinfo.Controller;

import com.alibaba.fastjson.JSON;
import com.lzx.getbookinfo.model.Book;
import com.lzx.getbookinfo.repository.BookRepository;
import com.lzx.getbookinfo.service.impl.GetBookInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GetInfoController {
    @Autowired
    private GetBookInfoServiceImpl getBookInfoService;
    @Autowired
    private BookRepository bookRepository;
    @ResponseBody
    @RequestMapping("/start")
    public String getAndInsert() {
        String url = "http://apis.juhe.cn/goodbook/query";
        Map<String, String> params = new HashMap<>();
        params.put("key", "cd2ff5f23109ca184f11b0627806cd92");//应用APPKEY(应用详细页查询)
        params.put("catalog_id", "243");//目录编号
        params.put("pn", "0");//数据返回起始
        params.put("rn", "30");//数据返回条数，最大30
        params.put("dtype", "json");//返回数据的格式,xml或json，默认json
        for (int j=242;j<=242;j++) {
            params.replace("catalog_id",String.valueOf(j));
            for (int i = 0; i <= 8; i++) {
                params.replace("pn", String.valueOf(i));
                String returndata = getBookInfoService.getContent(url, params);
                Map map = JSON.parseObject(returndata, Map.class);
                Map resultmap = (Map) map.get("result");
                List booklist = (List) resultmap.get("data");
                for (Object object : booklist
                ) {
                    Book book = JSON.parseObject(String.valueOf(object), Book.class);
                    if ( bookRepository.existsByTitle(book.getTitle())){
                        continue;
                    }else {
                        bookRepository.save(book);
                    }
                }

            }
        }
      return "success";
    }
}
