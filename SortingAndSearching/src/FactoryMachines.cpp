

#include<bits/stdc++.h>
using namespace std;

#define ll long long
#define mod 1000000007
#define maxn 200005
#define endl '\n'
#define add push_back

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

vector<int> v;
bool possible(ll int n, int k) {
	for (int i : v) {
		ll int count = n / i;

		if (count > k) return true;
		k -= count;
	}

	return k <= 0;
}

void solve() {
	int n = ni(), k = ni();
	for (int i = 0; i < n; i++) v.add(ni());
	sort(v.begin(), v.end());

	ll start = 1, last = (ll int) 1e18, ans = last;
	while (start <= last) {
		ll int mid = start + (last - start) / 2;

		if (possible(mid, k)) {
			last = mid - 1;
			ans = mid;
		}
		else start = mid + 1;
	}

	printf("%lld\n", ans);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr) , cout.tie(nullptr);
	int t = 1;
	// t = ni();

	while (t--) {
		solve();
	}

	return 0;
}
