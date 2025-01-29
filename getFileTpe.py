import re

class FileCategory:
    IMAGE = "image"
    VIDEO = "video"
    AUDIO = "audio"
    DOCUMENT = "document"
    ARCHIVE = "archive"
    EXECUTABLE = "executable"
    CODE = "code"
    FONT = "font"
    DATABASE = "database"
    MODEL = "3d-model"
    DISK_IMAGE = "disk-image"
    CONFIG = "config"
    FILE = "file"

mime_type_map = {
    "avif": "image/avif", "jpeg": "image/jpeg", "jpg": "image/jpeg", "png": "image/png",
    "bmp": "image/bmp", "gif": "image/gif", "svg": "image/svg+xml", "webp": "image/webp",
    "ico": "image/vnd.microsoft.icon", "tif": "image/tiff", "tiff": "image/tiff",
    "psd": "image/vnd.adobe.photoshop", "ai": "application/postscript", "sketch": "application/sketch",
    "mp4": "video/mp4", "webm": "video/webm", "ogv": "video/ogg", "avi": "video/x-msvideo",
    "mpeg": "video/mpeg", "3gp": "video/3gpp", "3g2": "video/3gpp2", "mp3": "audio/mpeg",
    "wav": "audio/wav", "weba": "audio/webm", "oga": "audio/ogg", "opus": "audio/opus",
    "midi": "audio/midi", "aac": "audio/aac", "pdf": "application/pdf", "doc": "application/msword",
    "docx": "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "xls": "application/vnd.ms-excel",
    "xlsx": "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "ppt": "application/vnd.ms-powerpoint",
    "pptx": "application/vnd.openxmlformats-officedocument.presentationml.presentation", "txt": "text/plain",
    "csv": "text/csv", "rtf": "application/rtf", "odt": "application/vnd.oasis.opendocument.text",
    "zip": "application/zip", "rar": "application/vnd.rar", "7z": "application/x-7z-compressed",
    "tar": "application/x-tar", "gz": "application/gzip", "bz2": "application/x-bzip2", "exe": "application/x-msdownload",
    "sh": "application/x-sh", "bat": "application/x-msdos-program", "apk": "application/vnd.android.package-archive",
    "ipa": "application/octet-stream", "jar": "application/java-archive", "app": "application/x-macos-app",
    "deb": "application/x-deb", "rpm": "application/x-rpm", "js": "text/javascript", "ts": "text/typescript",
    "py": "text/x-python", "java": "text/x-java-source", "cpp": "text/x-c", "c": "text/x-c", "kt": "text/x-kotlin",
    "rs": "text/x-rust", "swift": "text/x-swift", "go": "text/x-go", "php": "text/x-php", "rb": "text/x-ruby",
    "sqlite": "application/x-sqlite3", "db": "application/x-database", "sql": "application/sql", "stl": "model/stl",
    "obj": "model/obj", "fbx": "model/fbx", "blend": "model/blender", "iso": "application/x-iso9660-image",
    "img": "application/octet-stream", "ini": "text/plain", "log": "text/plain", "cfg": "text/plain",
    "ttf": "font/ttf", "woff": "font/woff", "woff2": "font/woff2", "otf": "font/otf"
}

category_map = {
    "image/": FileCategory.IMAGE, "video/": FileCategory.VIDEO, "audio/": FileCategory.AUDIO,
    "application/pdf": FileCategory.DOCUMENT, "application/msword": FileCategory.DOCUMENT,
    "application/vnd.openxmlformats-officedocument": FileCategory.DOCUMENT, "application/vnd.ms-powerpoint": FileCategory.DOCUMENT,
    "application/vnd.oasis.opendocument": FileCategory.DOCUMENT, "application/vnd.ms-excel": FileCategory.DOCUMENT,
    "text/plain": FileCategory.DOCUMENT, "text/csv": FileCategory.DOCUMENT, "application/rtf": FileCategory.DOCUMENT,
    "application/zip": FileCategory.ARCHIVE, "application/vnd.rar": FileCategory.ARCHIVE, "application/x-7z-compressed": FileCategory.ARCHIVE,
    "application/x-tar": FileCategory.ARCHIVE, "application/gzip": FileCategory.ARCHIVE, "application/x-bzip2": FileCategory.ARCHIVE,
    "application/x-msdownload": FileCategory.EXECUTABLE, "application/vnd.android.package-archive": FileCategory.EXECUTABLE,
    "application/octet-stream": FileCategory.EXECUTABLE, "application/java-archive": FileCategory.EXECUTABLE,
    "application/x-deb": FileCategory.EXECUTABLE, "application/x-rpm": FileCategory.EXECUTABLE,
    "text/javascript": FileCategory.CODE, "text/typescript": FileCategory.CODE, "text/x-python": FileCategory.CODE,
    "text/x-java-source": FileCategory.CODE, "text/x-c": FileCategory.CODE, "text/x-kotlin": FileCategory.CODE,
    "text/x-rust": FileCategory.CODE, "text/x-swift": FileCategory.CODE, "text/x-go": FileCategory.CODE,
    "text/x-php": FileCategory.CODE, "text/x-ruby": FileCategory.CODE, "application/x-sqlite3": FileCategory.DATABASE,
    "application/x-database": FileCategory.DATABASE, "application/sql": FileCategory.DATABASE, "model/": FileCategory.MODEL,
    "application/x-iso9660-image": FileCategory.DISK_IMAGE, "text/plain": FileCategory.CONFIG, "font/": FileCategory.FONT
}

def get_file_type(url: str) -> dict:
    extension = re.search(r"\.([0-9a-z]+)", url)
    if not extension:
        return {"mimeType": "unknown", "category": FileCategory.FILE}

    extension = extension.group(1).lower()
    mime_type = mime_type_map.get(extension, "application/octet-stream")

    category = category_map.get(mime_type)
    if not category:
        category = next((value for key, value in category_map.items() if mime_type.startswith(key)), FileCategory.FILE)

    return {"mimeType": mime_type, "category": category}

# Test
print(get_file_type("example.jpg")["mimeType"])
