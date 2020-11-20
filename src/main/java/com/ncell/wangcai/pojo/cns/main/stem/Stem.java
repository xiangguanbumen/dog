package com.ncell.wangcai.pojo.cns.main.stem;

import com.ncell.wangcai.pojo.cns.main.part.ElementCss;
import com.ncell.wangcai.pojo.cns.main.part.ElementJs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 所有pojo实体类的父类
 * @update
 * 2020年6月26日10:54:55
 * 考虑编程的复杂性，以及时间精力，本着先运行再完善的原则，
 * 将高于cell的pojo结构不再使用，通过cell中的变量type来实现pojo分类
 *
 * @author anliwei
 * @create 2020/6/8 14:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component()
@Scope("prototype")
public class Stem implements Serializable {

    int id=1;

    String name = "";
    /**
     * 类型，0表示实体，1表示关系
     * @update
     * 2020年7月2日12:57:44
     * 因为所有的实体目前都使用细胞表示
     * 暂时不使用实体和关系的分类，
     * 不同的数字代表不同的细胞类型
     *
     * 建立一个常量池，
     * 感知cell就是从各种根式转换成细胞格式的转换器，
     * cell
     * 未分类细胞 1
     * textcell 11
     * soundcell 12
     * imagecell 13
     *
     * tissue
     * agent
     * scene
     * story
     *
     * @update
     * 2020年7月17日22:34:53
     * 增加一个类型为感知细胞
     * 用来表示眼睛，耳朵，鼻子，身体皮肤的感觉细胞
     * 以区分皮层的细胞
     * 以及执行细胞，比如肌肉细胞，腺体细胞等
     */
    int type = 0;

    /**
     * 用0表示静息，1表示兴奋
     */
    int currentState = 0;

    /**
     * 绝对时间
     */
    long currentStateStartTime;

    /**
     *
     * @update
     * 2020年7月17日22:36:57
     *
     * 增加一个表示当前状态的
     * 系统时间
     * 事件时间
     * （事件有开始有结束，这里只使用开始时间，数值是与绝对时间一致的）
     *
     */

    long currentStateStartTimeInEventTime;

    /**
     *
     * @update
     * 2020年7月17日22:40:33
     *
     * 增加一个表示细胞兴奋发送时间用
     * 绝对时间
     *
     */
    long impulseTime;

    /**
     *
     * @update
     * 2020年7月17日22:44:02
     *
     * 增加一个表示细胞兴奋发送时间用
     * 事件时间
     * （事件有开始有结束，这里只使用开始时间，数值是与绝对时间一致的）
     *
     */

    long impulseTimeInEventTime;

    /**
     * 状态持续时间.默认兴奋持续时间1000毫秒
     */
    long excitedStateDuration =1000;

    /**
     * 不应期持续时间
     */
    long refractoryPeriod;






    /**
     * 输入连接
     */
    HashSet<String> connectionsInput= new HashSet<>();

    /**
     * 输出连接
     */

    HashSet<String> connectionsOutput=new HashSet<String>();


    /**
     * 输出消息,根据connectionOutput来决定给那个pojo传送消息
     */

    LinkedList<String> messagesOutput =new LinkedList<>();

    /**
     * 输入消息，与connectionsInput相比较来确定自身的状态
     * 是自身通过下层的兴奋来激活的，
     */
    LinkedList<String> messagesInput =new LinkedList<>();

    /**
     * 组成元素,使用元素的名称，需要的时候根据元素名称到仓库去取
     *
     * 当自身pojo兴奋的是可以直接兴奋，它的自身组成element
     * 是上层直接激活。
     *
     * 2020年7月2日16:57:39
     * 先运行再迭代，暂时先不使用element元素
     */
    HashSet<String> elements;

    /**
     * 元素静态组合
     */
    ElementCss elementCSS;

    /**
     * 元素动态组合
     */

    ElementJs elementJS;
}
