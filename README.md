# Sequent

<img src=https://github.com/fujiyuu75/sequent/blob/res/demo.gif width=400px>

Sequent is a library that starts animation continuously for multiple views at regular intervals.

```
# Views inheriting ViewGroup are available.
# e.g. LinearLayout, RelativiLayout, framelayout, etc
LinearLayout layout = (LinearLayout) v.findViewById(R.id.layout);

# Just write a line. Default animation is Fadein.
Sequent.origin(layout).start()
```

You can change the animation settings.

```
Sequent
   .origin(viewGroup)
   .duration(int) // option.
   .delay(int) // option. StartOffSet time.
   .offset(int) // option. Interval time.
   .flow(Direction) // option. Flow of animations in (FORWARD/BACKWARD/RANDOM). 
   .anim(Context, Animation) or .anim(Context, int) // option. implemented Animation or ObjectAnimator xml resource.
   .start()
```

Please use the following implemented animation effects.

```bounceIn``` ```fadeIn``` ```fadeInDown``` ```fadeInLeft``` ```fadeInRight``` ```fadeInUp``` ```rotateIn```

## Download

```
dependencies {
  compile 'com.fujiyuu75:sequent:0.2.1'
}
```

Continuous animation library like Sequent is also available for [iOS](https://github.com/fujiyuu75/Sequents).

## Bugs and Feedback

For bugs, questions and discussions please use the github issues.

## License

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
