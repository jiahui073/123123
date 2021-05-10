package o1083026.pu.edu.tw.myapplication

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.ColorFilterTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import o1083026.pu.edu.tw.myapplication.GlideOptions.bitmapTransform

@GlideModule
public final class MyAppGlideModule : AppGlideModule()



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img: ImageView = findViewById(R.id.img)
        val multi = MultiTransformation<Bitmap>(
            BlurTransformation(25),
            RoundedCornersTransformation(128, 0, RoundedCornersTransformation.CornerType.ALL),
            ColorFilterTransformation(Color.argb(80, 0, 0, 255))

        )

        GlideApp.with(this)
            .load(R.drawable.earth)
            .apply(bitmapTransform(multi))
            .into(img)

    }
}