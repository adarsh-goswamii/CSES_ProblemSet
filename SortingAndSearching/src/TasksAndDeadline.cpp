
#include<bits/stdc++.h>
using namespace std;

#define ll long long
#define mod 1000000007
#define maxn 200005
// #define endl '\n'
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

bool comp(vector<int> a, vector<int> b) {
	if (a[0] < b[0]) return true;
	else if (a[0] == b[0] && a[1] < b[1]) return true;
	else return false;
}

void solve() {
	int n = ni();

	vector<vector<int>> v;
	for (int i = 0; i < n; i++) {
		vector<int> temp(2, 0);
		temp[0] = ni(); // duration
		temp[1] = ni(); // deadline

		v.add(temp);
	}

	sort(v.begin(), v.end(), comp);
	ll int ans = 0, curr = 0;
	for (auto i : v) {
		curr += i[0];
		ans += i[1] - curr;
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
