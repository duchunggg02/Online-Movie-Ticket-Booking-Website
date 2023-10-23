/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndh.service;

import com.ndh.pojo.Phanhoi;
import java.util.List;

/**
 *
 * @author Duc Hung
 */
public interface PhanHoiService {
    List<Phanhoi> getFeedbacks();
    boolean addOrUpdateFeedback(Phanhoi p);
    Phanhoi getFeedbackById(int id);
    boolean deleteFeedback(int id);
    List<Phanhoi> getFeedbackByPhimId(int id);
    Phanhoi addFeedback(Phanhoi p);
}
