# File Type Detector

A utility function to determine the MIME type and category of a file based on its URL or file extension.

## Installation

This function does not require any external dependencies. Simply copy the function into your TypeScript/JavaScript project.

## Usage

### Example 1: Detecting a file type
```typescript
const fileInfo = getFileType("example.mp4");
console.log(fileInfo); 
// Output: { mimeType: "video/mp4", category: "video" }
```

### Example 2: Handling unknown file extensions
```typescript
const fileInfo = getFileType("unknown.xyz");
console.log(fileInfo); 
// Output: { mimeType: "application/octet-stream", category: "file" }
```

### Example 3: Detecting an image
```typescript
const fileInfo = getFileType("picture.jpeg");
console.log(fileInfo);
// Output: { mimeType: "image/jpeg", category: "image" }
```

---

# تشخیص نوع فایل

یک تابع کمکی برای تشخیص نوع MIME و دسته‌بندی یک فایل بر اساس URL یا پسوند آن.

## نصب

این تابع به هیچ وابستگی خارجی نیاز ندارد. کافیست آن را در پروژه TypeScript/JavaScript خود کپی کنید.

## استفاده

### مثال ۱: تشخیص نوع فایل
```typescript
const fileInfo = getFileType("example.mp4");
console.log(fileInfo); 
// خروجی: { mimeType: "video/mp4", category: "video" }
```

### مثال ۲: مدیریت پسوندهای ناشناخته
```typescript
const fileInfo = getFileType("unknown.xyz");
console.log(fileInfo); 
// خروجی: { mimeType: "application/octet-stream", category: "file" }
```

### مثال ۳: تشخیص تصویر
```typescript
const fileInfo = getFileType("picture.jpeg");
console.log(fileInfo);
// خروجی: { mimeType: "image/jpeg", category: "image" }
