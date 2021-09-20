Problem Set 01 Asnwers

1B:

1. Θ(1), because addition is always constant

2. Θ(3n), Ω(1), O(3 * n), this is because the first for loop is constantly run 3 times and the second is run n times. Ignoring the constant time lines, you multiple the for loop run times, 3 and n.

3. Θ(n^2), Ω(1) because if n = 1, 1*1 = 1. O(n*n) ignoring the constant times.

4. Θ(n^2), Ω(n-1), O(n^2), because ignoring constants the first for loop runs n, the second for loop can be rewritten as (j=i; j < n-1; j++) because if j=i+1, j+1 < n, then you subtract 1 from both sides of the statement. The rest is constant runtime, therefore, O(n^2) because factored out, n^2 is the most significant component.

5. Θ(n^2), Ω(n^2), O(n^2), the first for loop runs in n-1, and ignoring constants, n. The second loop runs in (n-1)/2, again ignoring constants, is n.

6. Θ(n^2), Ω(n^2), O(n^2), the first loop runs in (n-1)/2, and ignoring constants, n. The second loop runs in n-1, again ignoring constants, runs in n.

1C:

moveToPos(2);
remove();

Break-even points:

a) 30 > 30(2)/(4+30) -> 30 > 60/34 -> 30 > ~1.7, the array is more efficient.

b) 30 > 30(1)/(4+30) -> 30 > 30/34 -> ~0.8, the array is more efficient.

c) 40 > 40(32)/(4+40) -> 40 > 1280/44 -> 40 > ~29.1, the array is more efficient.

1D:

1. 2, 20n, log3(n), log2(n), n^(2/3), 4n^2, n!, 3^n

2. 

a) O(n)

b) O(n^3)

c) O(nlog2(n))

d) O(2^n)