

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

vector<vector<int>> v;
bool twoSum(int &start, int &last, int find) {
	while (start < last) {
		if (v[start][0] + v[last][0] == find) return true;
		else if (v[start][0] + v[last][0] < find) start++;
		else last--;
	}

	return false;
}

bool comp(vector<int> a, vector<int> b) {
	if (a[0] < b[0]) return true;
	else if (a[0] == b[0] && a[1] < b[1]) return true;
	else return false;
}

void solve() {
	int n = ni(), find = ni();

	for (int i = 0; i < n; i++) {
		vector<int> temp(2);
		temp[0] = ni();
		temp[1] = i + 1;

		v.push_back(temp);
	}

	sort(v.begin(), v.end(), comp);
	bool found = false;
	for (int i = 0; i < n; i++) {
		int key = find - v[i][0];

		int start = i + 1, last = n - 1;
		if (twoSum(start, last, key)) {
			found = true;
			cout << v[i][1] << " " << v[start][1] << " " << v[last][1] << endl;
			break;
		}
	}

	if (!found) cout << "IMPOSSIBLE" << endl;
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
