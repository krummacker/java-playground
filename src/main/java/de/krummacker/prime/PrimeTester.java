package de.krummacker.prime;

/**
 * A PrimeTester can find out if a given number is a prime.
 */
public class PrimeTester {

    /**
     * Creates a PrimeTester.
     */
    public PrimeTester() {
        // Intentionally left empty
    }

    /**
     * Finds out if the specified number is a prime.
     *
     * @param n the number to be tested
     * @return true if the number is a prime
     */
    public boolean isPrime(int n) {

        // by definition primes must always be greater than 1
        if (n < 2) {
            return false;
        }

        // it is sufficient to check until half of n
        for (int i = 2; i < n/2 + 1; ++i) {
            if (n % i == 0) {
                // no remainder means that this is not a prime
                return false;
            }
        }

        // the if above was never true, hence this must be a prime
        return true;
    }
}
