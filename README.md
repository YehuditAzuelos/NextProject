פרויקט אוטומציה לאתר נקסט

תיאור המערכת: האתר מציע שירות לרכישת בגדים, הנעלה וומוצרים לבית
האתר מחולק לפי קטגוריות ומאפשר איסוף לסל קניות ורכישת מוצרים
.כל אחד יכול להיכנס לאתר ולבצע קניות על מוצרים המוצעים בו

מטרת הפרויקט: לבצע TEST UNITY לאתר NEXT

מבנה הפרויקט: 

שפת פיתוח הפרויקט: JAVA

סביבת פיתוח Intellij ide :IDE

תוכנות צד שלישי: Selenium WebDriver,Junit,ExtentReports,Maven

כתובת אתר: https://www.next.co.il/en

בפרויקט נעשה שימוש ב- ChromeDriver.

ניתן להורידו בקישור זה: https://chromedriver.storage.googleapis.com/index.html?path=107.0.5304.62/ 

ניתן להחליף את הנתיב שבו ממוקם ה-driver כך:

יש להיכנס ל
-Constans :Class

ולהחליף את הנתיב של URL_CHROME_DRIVER לנתיב הרצוי.

צילומי המסך  שנוצרים במקרים של תקלות נשמרים בנתיב הזה:  nextProject\target\spark\pictures

ניתן להחליפו כך:

יש להיכנס ל
-Constans :Class

ולהחליף את הנתיב של URL_PICTRUES לנתיב הרצוי.

קובץ ה-XML שבו ישנם פרמטרים כמו URL ו-PASSWORDS קיים בנתיב זה: nextProject\target

ניתן להחליף את הנתיב שלו מ -Constans :Class

מוגדר כ: URL_CONFIGXML.

וכן קובץ ה-REPORTS ממוקם בנתיב זה: nextProject\target/Spark/index.html

ניתן להחליף את הנתיב שלו מ -Constans :Class

מוגדר כ: URL_REPORTS.

בהצלחה:)
