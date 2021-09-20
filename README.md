### Code Explanation - MemesAdapter
Replace the below paramaters with your model class
```kotlin
class OnClickListener(val clickListener: (meme: Meme) -> Unit) {
    fun onClick(meme: Meme) = clickListener(meme)
}
```
We have created a class called `OnClickListener` that takes in a lambda with
one Meme item as a parameter in its Constructor. This class contains a matching function called `onClick` that will set to the lambda parameter. All this creates a sort of a named lambda

```kotlin
class MemesAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Meme, MemesAdapter.MyViewHolder>(MyDiffUtil) 
```
Then we have added an onClickListener property on the Constructor of the `MemesAdapter`



```kotlin
holder.itemView.setOnClickListener {
            onClickListener.onClick(meme)
}
```
We finish our work in MemesAdapter by calling our `onClickListener` inside the `itemView's` onClickListener in `onBindViewHolder` with a Meme from the `ViewHolder`

### Code Explanation - MainActivity
 ```kotlin
 adapter = MemesAdapter(MemesAdapter.OnClickListener { photo ->
            Toast.makeText(applicationContext, "${photo.name}", Toast.LENGTH_SHORT).show()
  })
 ```

 In the MemesAdapter instance, we'll add MemesAdapter `OnClickListener` object to the MemesAdapter Constructor which returns a passed in Meme from the Adapter. For now we can try and Toast the name of the clicked Meme. On other scenarios one may need to navigate to other activities or fragments and display details of the clicked item.

### Demo
<p float="left">
<img src="screenshotz/Screenshot_20210615-193004.png" width=250/>
<img src="screenshotz/Screenshot_20210615-193014.png" width=250/>
  </p>
