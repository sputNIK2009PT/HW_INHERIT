import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Починить машину");

        String[] subtasks = {"Инструмент", "Свет", "Время"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Отдохнуть с друзьями",
                "В баре",
                "В субботу вечером"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestSearch() {
        SimpleTask simpleTask = new SimpleTask(8, "Выпить лекарство");

        String[] subtasks = {"стакан", "лекарство", "стол"};
        Epic epic = new Epic(76, subtasks);

        Meeting meeting = new Meeting(
                9,
                "Попасть на встречу",
                "Возле аэропорта",
                "17:30 в четверг"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = searchTodo.search("лекарство");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldTestSearch2() {
        SimpleTask simpleTask = new SimpleTask(19, "Покормить кота");

        String[] subtasks = {"Забрать детей", "Вынести мусор", "Выключить свет"};
        Epic epic = new Epic(82, subtasks);

        Meeting meeting = new Meeting(
                21,
                "Поиграть с котом",
                "Мячиком",
                "Вечером во вторник"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {simpleTask, meeting};
        Task[] actual = searchTodo.search("кот");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldTestSearch3() {
        SimpleTask simpleTask = new SimpleTask(1, "Записаться к мастеру");

        String[] subtasks = {"футболка", "кепка", "кросовки"};
        Epic epic = new Epic(12, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Запись в СТО",
                "Починиться у мастера",
                "13:00 послезавтра"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {simpleTask, meeting};
        Task[] actual = searchTodo.search("мастер");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldTestSearch4() {
        SimpleTask simpleTask = new SimpleTask(10, "Встреча с другом");

        String[] subtasks = {"футболка", "шорты", "буцы"};
        Epic epic = new Epic(100, subtasks);

        Meeting meeting = new Meeting(
                120,
                "Играем в футбол",
                "Любительская игра",
                "10:00 в воскресенье"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = searchTodo.search("футбол");
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testSearchSomeTasks() {
        SimpleTask simpleTask = new SimpleTask(16, "Сходить в магазин за кефиром");

        String[] subtasks = {"кефир", "колбаса", "сыр"};
        Epic epic = new Epic(26, subtasks);

        Meeting meeting = new Meeting(
                306,
                "Поставить кефир в холодильник",
                "Уталить жажду",
                "13:00 сегодня"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = searchTodo.search("кефир");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNoTasks() {
        SimpleTask simpleTask = new SimpleTask(25, "Заказать доставку");

        String[] subtasks = {"хлеб", "колбаса", "сыр"};
        Epic epic = new Epic(215, subtasks);

        Meeting meeting = new Meeting(
                305,
                "Сделать заявку",
                "Приготовить обед",
                "Завтра"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {};
        Task[] actual = searchTodo.search("курьер");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchOneTasks() {
        SimpleTask simpleTask = new SimpleTask(37, "Родительское собрание");

        String[] subtasks = {"блокнот", "ручка", "телефон"};
        Epic epic = new Epic(27, subtasks);

        Meeting meeting = new Meeting(
                307,
                "Выехать с работы",
                "Школа",
                "в пятницу вечером"
        );

        Todos searchTodo = new Todos();
        searchTodo.add(simpleTask);
        searchTodo.add(epic);
        searchTodo.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = searchTodo.search("собрание");
        Assertions.assertArrayEquals(expected, actual);
    }

    // другие тесты для максимального покрытия (для себя)
    @Test
    public void testGetTitle() {
        SimpleTask task = new SimpleTask(1, "Пример");
        assertEquals("Пример", task.getTitle());
    }

    @Test
    public void testGetSubtasks() {
        String[] subtasks = {"Пример 1", "Пример 2", "Пример 3"};
        Epic epic = new Epic(1, subtasks);
        assertArrayEquals(subtasks, epic.getSubtasks());
    }

    @Test
    public void testGetTopic() {
        Meeting meeting = new Meeting(1, "Тема", "Проект", "2024-07-03 10:00");
        assertEquals("Тема", meeting.getTopic());
    }

    @Test
    public void testGetProject() {
        Meeting meeting = new Meeting(1, "Тема", "Проект", "2024-07-03 10:00");
        assertEquals("Проект", meeting.getProject());
    }

    @Test
    public void testGetStart() {
        Meeting meeting = new Meeting(1, "Тема", "Проект", "2024-07-03 10:00");
        assertEquals("2024-07-03 10:00", meeting.getStart());
    }

    @Test
    public void testGetId() {
        Task task = new Task(1);
        assertEquals(1, task.getId());
    }

    @Test
    public void testEquals_SameObject() {
        Task task = new Task(1);
        assertTrue(task.equals(task));
    }

    @Test
    public void testEquals_EqualObjects() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);
        assertTrue(task1.equals(task2));
    }

    @Test
    public void testEquals_DifferentObjects() {
        Task task1 = new Task(1);
        Task task2 = new Task(2);
        assertFalse(task1.equals(task2));
    }

    @Test
    public void testEquals_NullObject() {
        Task task1 = new Task(1);
        assertFalse(task1.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        Task task1 = new Task(1);
        String other = "Различные примеры";
        assertFalse(task1.equals(other));
    }
}


