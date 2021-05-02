#include<bits/stdc++.h>
using namespace std;

#define ll long long
#define mod 1000000007
#define maxn 200005
#define endl '\n'

void debug(int a[], int n) {
	for (int i = 0; i < n; i++)
		printf("%d ", a[i]);
	printf("\n");
}

int ni() {
	int n;
	scanf("%d", &n);
	return n;
}

ll int nl() {
	ll int n;
	scanf("%lld", &n);
	return n;
}

string ns() {
	string s;
	getline(cin, s);
	return s;
}

double nd() {
	double n;
	scanf("%lf", &n);
	return n;
}

ll int add(ll int a, ll int b) {
	if (a + b >= mod)
		return (a + b) - mod;
	else
		return a + b >= 0 ? a + b : a + b + mod;
}

ll int mul(ll int a, ll int b) {
	return (a * b) % mod;
}

/**
	
*/

void solve() {
	int n = ni();

	int a[n];
	for (int i = 0; i < n; i++) a[i] = i;

	int i = 0, step = 0, temp = n;
	while (temp) {
		if ((step & 1) && a[i % n] != -1) {
			printf("%d ", i % n + 1);
			a[i % n] = -1;
			temp--;
			step++;
		}

		if (a[i % n] != -1) step++;
		i++;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr) , cout.tie(nullptr);
	int t = 1;
	// t = ni();

	while (t--) {
		solve();
		printf("\n");
	}

	return 0;
}
