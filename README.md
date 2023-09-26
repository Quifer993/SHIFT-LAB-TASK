# SHIFT_LAB_TASK
Задачка на прохождение в Shift-lab

- Version Java: 17
- Version Maven: 3.8.1

## Команда для запуска
```
mvn compile exec:java -Dexec.mainClass="ru.zolotorevskii.task.ShiftLabTestApplication" -Dexec.args=""
```
# Примечания
Формат POST-запроса:
<br>
Числа(int):
    [[1, 2], [4, 9], ... , [5, 8]]
    
Символы(char):
    [['a', 'c'], ['b', 'g'], ... , ['n', 'z']]

Поиск минимального интервала - смотрится интервал, в котором минимальный start (start_min), и среди интервалов с 
start_min ищем минимальный end.
