1. Если мы из корректно записанного арифметического выражения, содержащего числа, знаки операций и открывающие и закрывающие круглые скобки выбросим числа и знаки операций, а затем запишем оставшиеся в выражении скобки без пробелов между ними, то полученный результат назовем правильным скобочным выражением [скобочное выражение "(()(()))" - правильное, а "()(" и "())(" - нет]. Найти число правильных скобочных выражений, содержащих N открывающихся и N закрывающихся скобок. N вводится с клавиатуры. N неотрицательное целое число.

Пример:
N = 1 (по одной скобке открывающейся и закрывающеся) - ответ 1<br>
()<br>
)(<br>
))<br>
((<br>
Только один правильный вариант

Для введенного числа 2 - 2 :<br>
()()<br>
(())<br>
То есть только два варианта, когда все открытые скобки правильно открываются/закрываются.
И так далее.

------------------------------------------------------------------------------------------------------------------------

2. You are given a list of cities. Each direct connection between two cities has its transportation cost (an integer bigger than 0). The goal is to find the paths of minimum cost between pairs of cities. Assume that the cost of each path (which is the sum of costs of all direct connections belongning to this path) is at most 200000. The name of a city is a string containing characters a,...,z and is at most 10 characters long.2)

Input

s [the number of tests <= 10]<br>
n [the number of cities <= 10000]<br>
NAME [city name]<br>
p [the number of neighbours of city NAME]<br>
nr cost [nr - index of a city connected to NAME (the index of the first city is 1)]<br>[cost - the transportation cost]<br>
r [the number of paths to find <= 100]<br>
NAME1 NAME2 [NAME1 - source, NAME2 - destination]<br>
[empty line separating the tests]<br>

Output

cost [the minimum transportation cost from city NAME1 to city NAME2 (one per line)]

Example

Input:<br>
1<br>
4<br>
gdansk<br>
2<br>
2 1<br>
3 3<br>
bydgoszcz<br>
3<br>
1 1<br>
3 1<br>
4 4<br>
torun<br>
3<br>
1 3<br>
2 1<br>
4 1<br>
warszawa<br>
2<br>
2 4<br>
3 1<br>
2<br>
gdansk warszawa<br>
bydgoszcz warszawa<br>

Output:
3<br>
2<br>

------------------------------------------------------------------------------------------------------------------------

3. Find the sum of the digits in the number 100! (i.e. 100 factorial)

{Correct answer: 648}
