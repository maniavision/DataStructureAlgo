import com.maniavision.adts.IStack;
import com.maniavision.impl.ArrayListStack;
import com.maniavision.impl.LinkedListStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

public class StackTest {
    @Test
    public void test_linked_list_stack() {
        testingStack(new LinkedListStack());
    }

    @Test
    public void test_array_list_stack() {
        testingStack(new ArrayListStack());
    }

    public void testingStack(IStack stack) {
        Assertions.assertTrue(stack.isEmpty());
        stack.push(30);
        stack.push(12);
        stack.push(88);
        stack.push(75);

        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals(4, stack.size());
        Assertions.assertEquals(75, stack.top());
        int top = stack.pop();
        Assertions.assertEquals(3, stack.size());
        Assertions.assertEquals(75, top);
        Assertions.assertEquals(88, stack.top());
        stack.pop();
        stack.pop();
        stack.pop();
        Assertions.assertThrowsExactly(EmptyStackException.class, () -> {
            stack.pop();
        });
    }
}
