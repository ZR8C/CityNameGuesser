package org.zr8c.cincinnati.data


fun levenshteinDistance(lhs: String, rhs: String): Int {
    val lhsLower = lhs.lowercase()
    val rhsLower = rhs.lowercase()
    val lhsLength = lhsLower.length
    val rhsLength = rhsLower.length

    val dp = Array(lhsLength + 1) { IntArray(rhsLength + 1) }

    for (i in 0..lhsLength) {
        for (j in 0..rhsLength) {
            if (i == 0) {
                dp[i][j] = j
            } else if (j == 0) {
                dp[i][j] = i
            } else {
                dp[i][j] = minOf(
                    dp[i - 1][j] + 1,
                    dp[i][j - 1] + 1,
                    dp[i - 1][j - 1] + if (lhsLower[i - 1] == rhsLower[j - 1]) 0 else 1
                )
            }
        }
    }

    return dp[lhsLength][rhsLength]
}