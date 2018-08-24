package com.ttyc.jdk;

import com.ttyc.jdk.assist.*;
import org.junit.Test;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassApi {

    @Test
    public void testToString(){
        Class<ClassApi> apiClass = ClassApi.class;
        System.out.println(apiClass.toString());
        System.out.println(apiClass.toGenericString());
    }

    @Test
    public void testAsSub(){
        Class<? extends User> subClass = SuperUser.class.asSubclass(User.class);
        System.out.println(subClass.getName());

        System.out.println(User.class.isAssignableFrom(SuperUser.class));
    }

    @Test
    public void testCast(){
        User user = new SuperUser();
        SuperUser superUser = SuperUser.class.cast(user);
        superUser.talk();

    }

    @Test
    public void testDesiredAssertionStatus(){
        boolean b = User.class.desiredAssertionStatus();
        System.out.println(b);
    }

    @Test
    public void testAnnotatedType(){
        AnnotatedType[] annotatedInterfaces = Person.class.getAnnotatedInterfaces();
        for (int i = 0; i < annotatedInterfaces.length; i++) {
            AnnotatedType annotatedTypes = annotatedInterfaces[i];
            String typeName = annotatedTypes.getType().getTypeName();
            System.out.println(typeName);
        }
    }

    @Test
    public void testPrimitive(){
        boolean ret1 = int.class.isPrimitive();
        boolean ret2 = Integer.class.isPrimitive();
        System.out.println(ret1);
        System.out.println(ret2);
    }

    @Test
    public void testType(){
        System.out.println(int[].class.isArray());
        System.out.println(Person.class.isInterface());
        System.out.println(UserType.class.isEnum());
        System.out.println(Clearable.class.isAnnotation());
    }

    @Test
    public void testMetaData(){
        System.out.println(int[].class.getSimpleName());
        System.out.println(int[].class.getName());
        System.out.println(int[].class.getTypeName());
        System.out.println(int[].class.getComponentType());

        System.out.println(User.Inner.class.getName());
        System.out.println(User.Inner.class.getCanonicalName());

        System.out.println(User.class.getPackage());
        System.out.println(User.class.getSimpleName());
        System.out.println(User.class.getTypeName());

        System.out.println(Modifier.toString(User.Inner.class.getModifiers()));
    }



    @Test
    public void testDeclared(){
        Class<SuperUser> superClass = SuperUser.class;

        System.out.println(Arrays.toString(superClass.getClasses()));
        System.out.println(Arrays.toString(superClass.getDeclaredClasses()));

        System.out.println(Arrays.toString(superClass.getMethods()));
        System.out.println(Arrays.toString(superClass.getDeclaredMethods()));

        System.out.println(Arrays.toString(superClass.getFields()));
        System.out.println(Arrays.toString(superClass.getDeclaredFields()));

        System.out.println(Arrays.toString(superClass.getAnnotations()));
        System.out.println(Arrays.toString(superClass.getDeclaredAnnotations()));

        System.out.println(Arrays.toString(superClass.getConstructors()));
        System.out.println(Arrays.toString(superClass.getDeclaredConstructors()));
    }

    @Test
    public void testInstance() throws Exception{
        Master master = new Master();
        boolean instance = User.class.isInstance(master);
        System.out.println(instance);

        User user = User.class.newInstance();
        user.talk();
    }

    @Test
    public void testEnum(){
        UserType[] enumConstants = UserType.class.getEnumConstants();
        for (UserType type : enumConstants){
            System.out.println(type);
        }
    }


    @Test
    public void testExtend(){
        Class<? super SuperUser> superclass = SuperUser.class.getSuperclass();
        System.out.println(superclass.getName());

        String typeName = SuperUser.class.getAnnotatedSuperclass().getType().getTypeName();
        System.out.println(typeName);
    }

    @Test
    public void testAnnotation(){
        AnnotatedType annotatedSuperclass = Master.class.getAnnotatedSuperclass();
        Flexable flexable = annotatedSuperclass.getAnnotation(Flexable.class);
        System.out.println(flexable);
        String typeName = annotatedSuperclass.getType().getTypeName();
        System.out.println(typeName);

        AnnotatedType[] annotatedInterfaces = User.class.getAnnotatedInterfaces();
        for (int i = 0; i < annotatedInterfaces.length; i++) {
            AnnotatedType annotatedInterface = annotatedInterfaces[i];
            String name = annotatedInterface.getType().getTypeName();
            System.out.println(name);
        }
    }
}
