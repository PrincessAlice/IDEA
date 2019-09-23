#include<iostream>
#include<cmath>
using namespace std;

//Å·À­·¨
float F(float t) {
	return (2 * t);
}

int Eular(float init, float a, float b, float h, float *result) {
	int k;
	float t;
	if (a > b) {
		return -1;
	}

	*result = init;
	k = 1;

	for (t = a; t <= b; t += h) {
		*result += F(t - h)*h;

		printf("%f   %d value if %f\n", t, k, *result);
		k++;
	}
	return 0;
}

int main82() {
	float a, b, h;
	float yt0, result;

	a = 0;
	b = 3;
	h = 0.01;
	yt0 = 0;

	Eular(yt0, a, b, h, &result);
	system("pause");
	return 0;
}
