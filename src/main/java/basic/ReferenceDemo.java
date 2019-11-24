package basic;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/*
 * 测试软引用
 * */
public class ReferenceDemo {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
    }

    //软引用
    @Test
    public void softReferenceTest() {
        ReferenceDemo demo = new ReferenceDemo();
        System.out.println("instance:" + demo);
        SoftReference<ReferenceDemo> softReference = new SoftReference<>(demo);
        /*
         * 此时ReferenceDemo对象有两个引用指向它
         * 1.demo
         * 2.softReference
         * */
        System.out.println("before gc:" + softReference.get());
        demo = null;//此时只有一个引用指向ReferenceDemo
        System.gc();
        System.out.println("after gc:" + softReference.get());

    }

    //弱引用
    @Test
    public void weakReferenceTest() {
        WeakReference<ReferenceDemo> weakReference = new WeakReference<>(new ReferenceDemo());
        /*
         * 此时ReferenceDemo对象有两个引用指向它
         * 2.weakReference
         * */
        System.out.println("before gc:" + weakReference.get());
        System.gc();
        System.out.println("after gc:" + weakReference.get());
    }

    //引用队列
    //当软,弱,虚引用对象的对象被回收
    @Test
    public void referenceQueue() {
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        WeakReference<ReferenceDemo> weakDemo = new WeakReference<>(new ReferenceDemo(), queue);
        System.out.println("弱引用对应的对象:" + weakDemo.get() + ",弱引用本身:" + weakDemo);
        System.out.println("队列中对象:" + queue.poll());
        /*
         * 队列中对象只有一个引用,就是weakDemo
         * */
        System.gc();//gc后队列中就有弱引用本身
        System.out.println("弱引用对应的对象:" + weakDemo.get() + ",弱引用本身:" + weakDemo);
        System.out.println("队列中对象:" + queue.poll());
    }

    //虚引用必须和引用队列关联起来
    @Test
    public void PhantomReferenceTest(){
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        ReferenceDemo demo = new ReferenceDemo();
        PhantomReference<ReferenceDemo> pr = new PhantomReference<>(demo, queue);
        System.out.println("before gc:"+pr.get()+","+queue.poll());
        demo = null;
        System.gc();
        System.out.println("after gc:"+pr.get()+","+queue.poll());
    }
}
