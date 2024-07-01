package com.ohgiraffers.blog.jaesuk.service;

import com.ohgiraffers.blog.jaesuk.model.dto.BlogDTO;
import com.ohgiraffers.blog.jaesuk.model.entity.JaesukBlog;
import com.ohgiraffers.blog.jaesuk.repository.JaesukRepository;
import com.ohgiraffers.blog.jaesuk.repository.JaesukRepository;
import com.ohgiraffers.blog.jaesuk.repository.JaesukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class JaesukService {

    private final JaesukRepository jeasuckRepository;

    @Autowired
    public JaesukService(JaesukRepository jeasuckRepository) {
        this.jeasuckRepository = jeasuckRepository;
    }

    @Transactional
    public int post(BlogDTO blogDTO) {
        List<JaesukBlog> jaesukBlogs = jeasuckRepository.findAll();
        // 도메인 로직
        for (JaesukBlog blog: jaesukBlogs) {
            if(blog.getBlogTitle().equals(blogDTO.getBlogTitle())){
                return 0;
            }
        }

        JaesukBlog saveBlog = new JaesukBlog();
        saveBlog.setBlogContent(blogDTO.getBlogContent());
        saveBlog.setBlogTitle(blogDTO.getBlogTitle());
        saveBlog.setCreateDate(new Date());
        JaesukBlog result  = jeasuckRepository.save(saveBlog);

        int resultValue = 0;

        if(result != null){
            resultValue = 1;
        }

        return resultValue;
    }
}