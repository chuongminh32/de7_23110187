package vn.iotstar.Services.Impl;

import vn.iotstar.Services.VideoService_23110187;
import vn.iotstar.entity.Video_23110187;
import vn.iotstar.entity.Category_23110187;
import vn.iotstar.entity.Users_23110187;
import vn.iotstar.Repository.VideoRepository_23110187;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl_23110187 implements VideoService_23110187 {

    @Autowired
    private VideoRepository_23110187 videoRepository;

    @Override
    public List<Video_23110187> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Page<Video_23110187> findAll(int page, int size) {
        return videoRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Video_23110187> findById(String videoId) {
        return videoRepository.findById(videoId);
    }

    @Override
    public Page<Video_23110187> searchByTitle(String keyword, int page, int size) {
        return videoRepository.findByTitleContainingIgnoreCase(keyword, PageRequest.of(page, size));
    }

    @Override
    public Page<Video_23110187> findByActive(Boolean active, int page, int size) {
        return videoRepository.findByActive(active, PageRequest.of(page, size));
    }

    @Override
    public Page<Video_23110187> findByCategory(Category_23110187 category, int page, int size) {
        return videoRepository.findByCategory(category, PageRequest.of(page, size));
    }

    @Override
    public Page<Video_23110187> findByUser(Users_23110187 user, int page, int size) {
        return videoRepository.findByCategory_User(user, PageRequest.of(page, size));
    }

    @Override
    public Video_23110187 save(Video_23110187 video) {
        return videoRepository.save(video);
    }

    @Override
    public void deleteById(String videoId) {
        videoRepository.deleteById(videoId);
    }
}
