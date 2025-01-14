package top.godder.datamodule.domain.dao;

import top.godder.datamoduleapi.domain.entity.DataFile;
import top.godder.datamoduleapi.domain.vo.DataFileReq;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
public interface DataFileDao {
    DataFile findByFiledId(Long fileId);

    List<DataFile> findByUserId(Long userId);

    /**
     * 返回该领域内所有文件
     * @param fieldId
     * @return
     */
    List<DataFile> findByFieldId(Long fieldId);

    List<DataFile> findAll();

    List<DataFile> findByFileName(String fileName);

    List<DataFile> findByReq(DataFileReq req);

    List<DataFile> findByUserBuy(Long userId);

    boolean buyFile(Long fileId, Long userId);

    boolean insertOne(DataFile dataFile);

    boolean deleteByFileId(Long fileId);

    boolean deleteByUserId(Long userId);

    /**
     * 删除该领域内的所有文件
     * @param fieldId
     * @return
     */
    boolean deleteByFieldId(Long fieldId);
}
