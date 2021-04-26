def execute(x):
    x = 5 if x<2 or x>15 else x
    fibonacci = (lambda x, x_1=1, x_2=0:
         x_2 if x == 0
         else fibonacci(x - 1, x_1 + x_2, x_1))
    return fibonacci(x)
