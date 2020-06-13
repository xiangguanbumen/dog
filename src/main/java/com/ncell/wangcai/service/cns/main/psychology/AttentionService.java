package com.ncell.wangcai.service.cns.main.psychology;

/**
 *注意是通过调节生理服务来实现的。
 *
 * 心理学中的注意，
 * 实现方法主要是通过将兴奋的pojo的插队到优先执行队列，同时将其他pojo排到兴奋队列的后部，或者抑制其他兴奋pojo
 *
 * 注意的排序原则，同级别复杂的优于简单的，不同级别高级的优于低级的。
 *
 * 注意本身分成，注意的广度和注意的深度两个维度
 * @author anliwei
 * @Date 2020/6/13 21:19
 */
public interface AttentionService {

    /**
     *  注意的宽度
     */

    int ATTENTION_WIDTH =5;

    /**
     *  注意的深度度
     */
    int ATTENTION_DEEPTH =3;


    /**
     * 在同级别中选择pojo，相当于选择的宽度
     */
    void pickPojoInSameLevel();

    /**
     * 在下级中选择pojo，相当于选择的深度
     */
    void pickPojoInSubLevel();


    /**
     * 调整筛选其他待发放pojo的速度
     */
    void adjustSpeedOfPojoRunService();

}
