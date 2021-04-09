package com.example.demo.Controller;

import com.example.demo.Bean.BeanPost;
import com.example.demo.Bean.ResultBean;
import com.example.demo.Service.PostService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;

@org.springframework.web.bind.annotation.RestController
public class PostController {

    @Autowired
    PostService postService;

    Logger logger = LoggerFactory.getLogger(PostController.class);

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean postController(@RequestBody BeanPost beanPost){

        logger.info(String.format("postController\npost => %s", beanPost.getKey() + "\t" + beanPost.getMsg()));

        return postService.postService(beanPost);
    }
}
