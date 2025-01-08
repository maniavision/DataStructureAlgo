import com.maniavision.adts.IList;
import com.maniavision.impl.ArrayList;
import com.maniavision.impl.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListTest {
    @Test
    public void test_array_list() {
        testList(new ArrayList());
    }

    @Test
    public void test_linked_list() {
        testList(new LinkedList());
    }

    private void testList(IList list) {
        list.add(50);
        list.add(12);
        list.add(77);
        list.add(2);

        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals(77, list.get(2));
        Assertions.assertEquals(-1, list.search(100));
        Assertions.assertEquals(3, list.search(2));
        Assertions.assertFalse(list.isEmpty());

        list.remove(77);
        Assertions.assertEquals(3, list.size());
        list.remove(2);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(12, list.get(1));
        list.remove(50);
        list.remove(12);
        Assertions.assertEquals(0, list.size());
        Assertions.assertTrue(list.isEmpty());
    }
}
