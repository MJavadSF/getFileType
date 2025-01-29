
# File Type Detector

A utility function to determine the MIME type and category of a file based on its URL or file extension.

## Installation

This function does not require any external dependencies. Simply copy the function into your TypeScript/JavaScript, Java, Kotlin, or Python project.

## Usage

### Example 1: Detecting a file type

#### TypeScript/JavaScript
```typescript
const fileInfo = getFileType("example.mp4");
console.log(fileInfo); 
// Output: { mimeType: "video/mp4", category: "video" }
```

#### Java
```java
FileTypeDetector.FileTypeResult result = FileTypeDetector.getFileType("example.mp4");
System.out.println(result.mimeType + ", " + result.category);
// Output: video/mp4, video
```

#### Kotlin
```kotlin
val fileInfo = getFileType("example.mp4")
println("${fileInfo.mimeType}, ${fileInfo.category}")
// Output: video/mp4, video
```

#### Python
```python
file_info = get_file_type("example.mp4")
print(f"{file_info['mimeType']}, {file_info['category']}")
# Output: video/mp4, video
```

### Example 2: Handling unknown file extensions

#### TypeScript/JavaScript
```typescript
const fileInfo = getFileType("unknown.xyz");
console.log(fileInfo); 
// Output: { mimeType: "application/octet-stream", category: "file" }
```

#### Java
```java
FileTypeDetector.FileTypeResult result = FileTypeDetector.getFileType("unknown.xyz");
System.out.println(result.mimeType + ", " + result.category);
// Output: application/octet-stream, file
```

#### Kotlin
```kotlin
val fileInfo = getFileType("unknown.xyz")
println("${fileInfo.mimeType}, ${fileInfo.category}")
// Output: application/octet-stream, file
```

#### Python
```python
file_info = get_file_type("unknown.xyz")
print(f"{file_info['mimeType']}, {file_info['category']}")
# Output: application/octet-stream, file
```

### Example 3: Detecting an image

#### TypeScript/JavaScript
```typescript
const fileInfo = getFileType("picture.jpeg");
console.log(fileInfo);
// Output: { mimeType: "image/jpeg", category: "image" }
```

#### Java
```java
FileTypeDetector.FileTypeResult result = FileTypeDetector.getFileType("picture.jpeg");
System.out.println(result.mimeType + ", " + result.category);
// Output: image/jpeg, image
```

#### Kotlin
```kotlin
val fileInfo = getFileType("picture.jpeg")
println("${fileInfo.mimeType}, ${fileInfo.category}")
// Output: image/jpeg, image
```

#### Python
```python
file_info = get_file_type("picture.jpeg")
print(f"{file_info['mimeType']}, {file_info['category']}")
# Output: image/jpeg, image
```

---

# تشخیص نوع فایل

یک تابع کمکی برای تشخیص نوع MIME و دسته‌بندی یک فایل بر اساس URL یا پسوند آن.

## نصب

این تابع به هیچ وابستگی خارجی نیاز ندارد. کافیست آن را در پروژه TypeScript/JavaScript، جاوا، کاتلین یا پایتون خود کپی کنید.

## استفاده

### مثال ۱: تشخیص نوع فایل

#### تایپ‌اسکریپت/جاوا اسکریپت
```typescript
const fileInfo = getFileType("example.mp4");
console.log(fileInfo); 
// خروجی: { mimeType: "video/mp4", category: "video" }
```

#### جاوا
```java
FileTypeDetector.FileTypeResult result = FileTypeDetector.getFileType("example.mp4");
System.out.println(result.mimeType + ", " + result.category);
// خروجی: video/mp4, video
```

#### کاتلین
```kotlin
val fileInfo = getFileType("example.mp4")
println("${fileInfo.mimeType}, ${fileInfo.category}")
// خروجی: video/mp4, video
```

#### پایتون
```python
file_info = get_file_type("example.mp4")
print(f"{file_info['mimeType']}, {file_info['category']}")
# خروجی: video/mp4, video
```

### مثال ۲: مدیریت پسوندهای ناشناخته

#### تایپ‌اسکریپت/جاوا اسکریپت
```typescript
const fileInfo = getFileType("unknown.xyz");
console.log(fileInfo); 
// خروجی: { mimeType: "application/octet-stream", category: "file" }
```

#### جاوا
```java
FileTypeDetector.FileTypeResult result = FileTypeDetector.getFileType("unknown.xyz");
System.out.println(result.mimeType + ", " + result.category);
// خروجی: application/octet-stream, file
```

#### کاتلین
```kotlin
val fileInfo = getFileType("unknown.xyz")
println("${fileInfo.mimeType}, ${fileInfo.category}")
// خروجی: application/octet-stream, file
```

#### پایتون
```python
file_info = get_file_type("unknown.xyz")
print(f"{file_info['mimeType']}, {file_info['category']}")
# خروجی: application/octet-stream, file
```

### مثال ۳: تشخیص تصویر

#### تایپ‌اسکریپت/جاوا اسکریپت
```typescript
const fileInfo = getFileType("picture.jpeg");
console.log(fileInfo);
// خروجی: { mimeType: "image/jpeg", category: "image" }
```

#### جاوا
```java
FileTypeDetector.FileTypeResult result = FileTypeDetector.getFileType("picture.jpeg");
System.out.println(result.mimeType + ", " + result.category);
// خروجی: image/jpeg, image
```

#### کاتلین
```kotlin
val fileInfo = getFileType("picture.jpeg")
println("${fileInfo.mimeType}, ${fileInfo.category}")
// خروجی: image/jpeg, image
```

#### پایتون
```python
file_info = get_file_type("picture.jpeg")
print(f"{file_info['mimeType']}, {file_info['category']}")
# خروجی: image/jpeg, image
```
