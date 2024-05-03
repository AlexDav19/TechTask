Тестовое задание Skypro.

Задача

Имеется некая система, которая обрабатывает авиаперелёты.
Перелёт — это перевозка пассажира из одной точки в другую с возможными промежуточными посадками.
Это значит, что перелёт можно представить как набор из одного или нескольких элементарных перемещений, называемых сегментами.
Сегмент — это атомарная перевозка, которую для простоты будем характеризовать всего двумя атрибутами: дата/время вылета и дата/время прилёта.

Данный модуль занимается фильтрацией набора перелётов согласно различным правилам.
Правил фильтрации может быть очень много.
Наборы перелётов также могут быть очень большими.
Правила могут выбираться и задаваться динамически в зависимости от контекста выполнения операции фильтрации.

Приложенный файл TestClasses.java содержит упрощённые модельные классы и фабрику для получения тестовых образцов.

Созданные методы исключают из тестового набора перелёты по следующим правилам:
Вылет до текущего момента времени.
Сегменты с датой прилёта раньше даты вылета.
Перелеты, где общее время, проведённое на земле, превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним).
