package com.heima.schedule.service;

import com.heima.model.schedule.dtos.Task;

/**
 * 对外访问接口
 */
public interface TaskService {

    /**
     * 添加任务
     * @param task   任务对象
     * @return       任务id
     */
    public long addTask(Task task);

    /**
     * 取消任务
     * @param taskId   任务id
     * @return
     */
    public boolean cancelTask(long taskId);

    /**
     * 按照类型和优先级拉取任务
     * @param type      任务类型
     * @param priority  任务优先级
     * @return
     */
    public Task poll(int type, int priority);

}