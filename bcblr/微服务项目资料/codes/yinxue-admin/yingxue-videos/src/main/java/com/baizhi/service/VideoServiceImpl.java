package com.baizhi.service;

import com.baizhi.dao.VideoDao;
import com.baizhi.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Video> findAllByKeywords(int offset, int limit, String id, String name, String categoryId, String username) {
        int start = (offset - 1) * limit;
        return videoDao.findAllByKeywords(start, limit, id, name, categoryId, username);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotalCountsByKeywords(String id, String name, String categoryId, String username) {
        return videoDao.findTotalCountsByKeywords(id, name, categoryId, username);
    }
}
