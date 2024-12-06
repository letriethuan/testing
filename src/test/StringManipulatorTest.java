package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.StringManipulator;

public class StringManipulatorTest {
   static StringManipulator manipulator = new StringManipulator();

   @Test
   public void testReverse() {

      // Normal cases
      assertEquals("ELPmAxE", manipulator.reverse("ExAmPLE"));
      assertEquals("avaJ", manipulator.reverse("Java"));

      // Edge cases
      assertEquals("", manipulator.reverse("")); // Empty string
      assertNull(manipulator.reverse(null)); // Null input
      assertEquals("a", manipulator.reverse("a")); // Single character
   }

   @Test
   public void testIsPalindrome() {

      // Test palindromes
      assertTrue(manipulator.isPalindrome("madam"));
      assertTrue(manipulator.isPalindrome("racecar"));
      assertFalse(manipulator.isPalindrome("AbleElba"));

      // Test non-palindromes
      assertFalse(manipulator.isPalindrome("hello"));
      assertFalse(manipulator.isPalindrome("Palindrome"));
      assertFalse(manipulator.isPalindrome("Java"));

      // Test edge cases
      assertTrue(manipulator.isPalindrome("a")); // Single character is a palindrome
      assertFalse(manipulator.isPalindrome("")); // Empty string is a palindrome
      assertFalse(manipulator.isPalindrome(null)); // Handle null gracefully
   }

   @Test
   public void testIsContained() {
      assertTrue(manipulator.isContained("ExAmPLE", "Ex"));
      assertTrue(manipulator.isContained("Java Programming", "Java"));
      assertTrue(manipulator.isContained("Hello World", "World"));

      // Test when the substring is not contained
      assertFalse(manipulator.isContained("ExAmPLE", "ex")); // Case-sensitive check
      assertFalse(manipulator.isContained("Java Programming", "java")); // Case-sensitive check
      assertFalse(manipulator.isContained("Hello World", "world")); // Case-sensitive check

      // Test edge cases
      assertTrue(manipulator.isContained("ExAmPLE", ""));
      assertFalse(manipulator.isContained("", "non-empty"));
      assertTrue(manipulator.isContained("", ""));
      assertFalse(manipulator.isContained(null, "test"));
      assertFalse(manipulator.isContained("test", null));
      assertFalse(manipulator.isContained(null, null));
   }

   @Test
   public void testNumberRemoved() {

      // Test cases with digits
      assertEquals("ExAmPLE", manipulator.numberRemoved("ExAm1PLE2"));
      assertEquals("abc", manipulator.numberRemoved("123abc456"));
      assertEquals("testtest", manipulator.numberRemoved("test123test"));

      // Edge cases
      assertEquals("", manipulator.numberRemoved("123"));
      assertEquals("", manipulator.numberRemoved(""));
      assertNull(manipulator.numberRemoved(null));
      assertEquals("NoDigitsHere", manipulator.numberRemoved("NoDigitsHere"));
   }

   @Test
   public void testUpperString() {
      assertEquals("EXAMPLE", manipulator.upperString("ExAmPLE"));
      assertEquals("HELLO", manipulator.upperString("hello"));
      assertEquals("JAVA", manipulator.upperString("JAVA"));
      assertEquals("JAVA123", manipulator.upperString("java123"));

      assertEquals("", manipulator.upperString(""));

      assertNull(manipulator.upperString(null));
   }

   @Test
   public void testLowerString() {
      assertEquals("example", manipulator.lowerString("ExAmPLE"));
      assertEquals("hello", manipulator.lowerString("HELLO"));
      assertEquals("java", manipulator.lowerString("java"));
      assertEquals("java123", manipulator.lowerString("JAVA123"));

      assertEquals("", manipulator.lowerString(""));

      assertNull(manipulator.lowerString(null));
   }

   @Test
   public void testCapitalString() {
      StringManipulator manipulator = new StringManipulator();
      assertEquals("Example String", manipulator.capitalString("example string"));
      assertEquals("Java Programming", manipulator.capitalString("java programming"));
      assertEquals("Hello World", manipulator.capitalString("HELLO WORLD"));
      assertEquals("Java 123 Test", manipulator.capitalString("java 123 test"));

      assertEquals("", manipulator.capitalString(""));

      assertNull(manipulator.capitalString(null));
   }

   @Test
   public void testCountVowels() {
      // Test with a string containing vowels
      assertEquals(3, manipulator.countVowels("example")); // 3 vowels ('e', 'a', 'e')
      assertEquals(5, manipulator.countVowels("education")); // 4 vowels ('e', 'u', 'a', 'i', 'o')
      assertEquals(2, manipulator.countVowels("hello")); // 2 vowels ('e', 'o')
      assertEquals(5, manipulator.countVowels("aeiou")); // 5 vowels ('a', 'e', 'i', 'o', 'u')

      // Test with a string containing no vowels
      assertEquals(0, manipulator.countVowels("rhythm"));

      // Test with an empty string
      assertEquals(0, manipulator.countVowels(""));
      // Test with a string containing only vowels
      assertEquals(7, manipulator.countVowels("aeiouae")); // 6 vowels ('a', 'e', 'i', 'o', 'u', 'a', 'e')

      // Test with a string containing mixed case vowels
      assertEquals(7, manipulator.countVowels("aEiOuAe")); // 6 vowels ('a', 'E', 'i', 'O', 'u', 'A','e')
   }

   @Test
   public void testCountWords() {
      // Test cases for different sentences

      // Test with a normal sentence
      assertEquals(4, manipulator.countWords("Hello, how are you?"));

      // Test with a sentence containing punctuation
      assertEquals(3, manipulator.countWords("Java is, great!"));

      // Test with multiple spaces between words
      assertEquals(3, manipulator.countWords("Java    is     great"));

      // Test with leading and trailing spaces
      assertEquals(3, manipulator.countWords("   Java is great   "));

      // Test with an empty sentence
      assertEquals(0, manipulator.countWords(""));

      // Test with a sentence containing only spaces
      assertEquals(0, manipulator.countWords("    "));

      // Test with a single word
      assertEquals(1, manipulator.countWords("Hello"));

      // Test with a null sentence
      assertEquals(0, manipulator.countWords(null));
   }

   @Test
   public void testFindSubstringIndex() {
      assertEquals(5, manipulator.findSubstringIndex("Java programming", "programming"));

      // Test with case-sensitive check where substring is not found
      assertEquals(-1, manipulator.findSubstringIndex("Java programming", "Programming"));

      // Test with input containing special characters
      assertEquals(4, manipulator.findSubstringIndex("Java, programming!", ","));

      // Test with an empty substring (should return 0 since the empty string is found
      // at the start of any string)
      assertEquals(0, manipulator.findSubstringIndex("Java programming", ""));

      // Test with substring longer than input (should return -1)
      assertEquals(-1, manipulator.findSubstringIndex("Java", "Java programming"));

      // Test with null input (should return -1)
      assertEquals(-1, manipulator.findSubstringIndex(null, "programming"));

      // Test with null substring (should return -1)
      assertEquals(-1, manipulator.findSubstringIndex("Java programming", null));

      // Test with both input and substring null (should return -1)
      assertEquals(-1, manipulator.findSubstringIndex(null, null));
   }

   @Test(timeout = 1000)
   public void testReverseWords() {
      // Test with a regular sentence
      assertEquals("You Are How World Hello", manipulator.reverseWords("Hello World How Are You"));

      // Test with a sentence with one word
      assertEquals("Hello", manipulator.reverseWords("Hello"));

      // Test with an empty sentence
      assertEquals("", manipulator.reverseWords(""));

      // Test with a null sentence (optional, can be handled with assertNull)
      assertNull(manipulator.reverseWords(null));

      // Test with a sentence containing multiple spaces between words
      assertEquals("You  Are   How   World    Hello", manipulator.reverseWords("Hello    World   How   Are  You"));

      // Test with only spaces (should return empty string)
      assertEquals("", manipulator.reverseWords("     "));

      // Test with sentence starting and ending with spaces
      assertEquals("You Are How World Hello  ", manipulator.reverseWords("  Hello World How Are You  "));
   }

}
