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

void solve() {
	int n = ni(), x = ni();
	map<int, int> interval;
	interval[n] = 1;

	set<int> lights;
	lights.insert(0);
	lights.insert(n);

	for (int i = 0; i < x; i++) {
		int val = ni();

		if (val == 0 || val == n) {
			printf("%d ", interval.rbegin()->first);
			continue;
		}
		else {
			auto it = lights.lower_bound(val);
			int upper = *it;
			int lower = *--it;
			lights.insert(val);

			int key = upper - lower;
			interval[key] -= 1;
			if (interval[key] == 0) interval.erase(key);

			if (interval.find(upper - val) != interval.end())
				interval[upper - val] += 1;
			else
				interval[upper - val] = 1;

			if (interval.find(val - lower) != interval.end())
				interval[val - lower] += 1;
			else
				interval[val - lower] = 1;
		}

		printf("%d ", interval.rbegin()->first);
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
