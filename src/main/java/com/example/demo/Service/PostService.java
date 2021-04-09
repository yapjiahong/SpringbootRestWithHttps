package com.example.demo.Service;

import com.example.demo.Bean.BeanPost;
import com.example.demo.Bean.ResultBean;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PostService {

    Logger loggger = LoggerFactory.getLogger(PostService.class);

    public ResultBean postService(BeanPost beanPost){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(200);
        resultBean.setMsg(String.format("processed by server => %s", beanPost.getMsg()));
        return resultBean;
    }

}
