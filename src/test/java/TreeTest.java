import com.maniavision.adts.IBinarySearchTree;
import com.maniavision.impl.BinarySearchTreeIterative;
import com.maniavision.impl.BinarySearchTreeRecursive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeTest {

    @Test
    public void test_bst_recursive() {
        testTree(new BinarySearchTreeRecursive());
    }

    @Test
    public void test_bst_iterative() {
        testTree(new BinarySearchTreeIterative());
    }

    @Test
    public void testTree(IBinarySearchTree tree) {
        tree.add(55);
        tree.add(40);
        tree.add(50);
        tree.add(35);
        tree.add(65);
        tree.add(60);
        tree.add(70);
        tree.add(68);

        Assertions.assertEquals(8, tree.size());
        Assertions.assertTrue(tree.search(65));
        Assertions.assertFalse(tree.search(90));
        Assertions.assertFalse(tree.isEmpty());
        tree.remove(60);
        Assertions.assertEquals(7, tree.size());
        tree.remove(40);
        Assertions.assertEquals(6, tree.size());
        tree.remove(70);
        Assertions.assertEquals(5, tree.size());

    }
}
