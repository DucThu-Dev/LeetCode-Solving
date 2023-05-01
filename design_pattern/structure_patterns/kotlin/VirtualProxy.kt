package design_pattern.structure_patterns.kotlin

interface ImageLoader {
    fun loadImage(id: String)
}

class ImageLoaderImpl : ImageLoader {
    override fun loadImage(id: String) {
        println("Image $id is loading, taking sometimes.")
    }
}

class ImageLoaderProxy : ImageLoader {
    private val image: ImageLoader by lazy { ImageLoaderImpl() }

    override fun loadImage(id: String) {
        image.loadImage(id);
    }
}

class Client(private val imageLoader: ImageLoaderProxy = ImageLoaderProxy()) {
    fun renderUI() {
        imageLoader.loadImage("The dummy image");
    }
}

fun main() {
    Client().apply { renderUI() }
}