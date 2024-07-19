package org.example;

import org.example.service.StringListImpl;

public class Main {
    public static void main(String[] args) {
        StringListImpl list1 = new StringListImpl();
        StringListImpl list2 = new StringListImpl();
        //Возвращение  добавленного элемента в качестве результата выполнения.
        System.out.println(list1.add("one"));
        System.out.println(list1.add("two"));
        System.out.println(list1.add("three"));
        System.out.println("Массив list1 после добавления трёх значений");
        System.out.println(list1);
        list2.add("one");
        list2.add("two");
        list2.add("three");
        //проверка на равенство массивов
        System.out.println("Проверка на равенство массивов List1 и List2");
        System.out.println(list1.equals(list2));
        //возвращение добавленного элемента  по индексу
        System.out.println(list1.add(7, "Zero"));
        System.out.println("Состояние массива после добавления элемента в соотвествующую ячейку");
        System.out.println(list1);
        //возвращение перезаписанного элемента по индексу
        System.out.println(list1.set(2, "byte"));
        System.out.println("Состояние массива после перезаписывания  элемента в соотвествующей ячейке");
        System.out.println(list1);
        System.out.println(list1.remove("byte"));
        System.out.println("Состояние массива  после  удаления соответствующего значения");
        System.out.println(list1);
        System.out.println(list1.remove(1));
        System.out.println("Состояние массива  после  удаления соответствующего значения по индексу");
        System.out.println(list1);
        System.out.println(list1.contains("one"));
        System.out.println(list1.indexOf("one"));
        //поиск элемента с конца
        System.out.println(list1.lastIndexOf("Zero"));
        //Получить элемент по индексу.
        System.out.println(list1.get(1));
        // Вернуть фактическое количество элементов.
        System.out.println(list1.size());
        System.out.println(list1.isEmpty());
        list1.toArray();
        list2.clear();
        System.out.println(list2);
    }
}