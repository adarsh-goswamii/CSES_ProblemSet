

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

// Logic is to let A start reading the books in ascending order 
// while B has to first read the longest book and then start from ascending order just like A

// The reason why this works, as B will never catch up with A, so there will be no wastage of time 
// Why? as B will be behind A by atleast the length of longest book and as we know it was the longest book so no other book will take more than that time 
// this will not allow B to catch up with A.

// My intuition was to divide the array in two subsets such that their total diff is minimum.........like subset sum problem
// then the ans would have been the sum of bigger subset *2

// but due to the given complexities that was not possible.

void solve() {
	int n = ni();

	vector<int> time;
	for (int i = 0; i < n; i++) time.add(ni());

	sort(time.begin(), time.end());
	ll int sum = 0;
	for (int i = 0; i < n - 1; i++) sum += time[i];

	if (sum > time[n - 1]) printf("%lld\n", sum + time[n - 1]);
	else printf("%lld\n", time[n - 1] * 2ll);
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
