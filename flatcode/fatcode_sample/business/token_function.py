def calc_token(n):
	if n<0:
		return -1
	elif n==1:
		return 0
	elif n==2:
		return 1
	else:
		return calc_token(n-1) + calc_token(n-2)

