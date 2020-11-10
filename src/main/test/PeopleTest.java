import com.wei1.work.crm.mapper.PeopleMapper;
import com.wei1.work.crm.sqlSessionUtil.SessionUtil;
import org.junit.Test;

public class PeopleTest {
    PeopleMapper peopleMapper = SessionUtil.getSqlSession().getMapper(PeopleMapper.class);
    @Test
    public void selectByUserName(){
        System.out.println(peopleMapper.selectById("27"));
    }
}
