
# <strong>time.api</strong> namespace
<p>Documentation of the <strong>time/api.cljs</strong> file</p>

<strong>[README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > time.api</strong>



### clear-interval!

```
@param (integer) interval-id
```

```
@return (nil)
```

<details>
<summary>Source code</summary>

```
(defn clear-interval!
  [interval-id]
  (.clearInterval js/window interval-id))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [clear-interval!]]))

(time/clear-interval! ...)
(clear-interval!      ...)
```

</details>

---

### date-string?

```
@param (*) n
```

```
@example
(date-string? "2020-04-20")
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn date-string?
  [n]
  (and (string? n)
       (re-matches #"\d{4}[-|.]\d{2}[-|.]\d{2}" n)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [date-string?]]))

(time/date-string? ...)
(date-string?      ...)
```

</details>

---

### elapsed

```
@usage
(elapsed)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn elapsed
  []
  (.now js/performance))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [elapsed]]))

(time/elapsed)
(elapsed)
```

</details>

---

### epoch-ms

```
@usage
(epoch-ms)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn epoch-ms
  [])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [epoch-ms]]))

(time/epoch-ms)
(epoch-ms)
```

</details>

---

### epoch-ms->timestamp-string

```
@param (ms) n
```

```
@example
(epoch-ms->timestamp-string 1640800860000)
=>
"2021-12-29T18:01:00.000Z"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn epoch-ms->timestamp-string
  [n])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [epoch-ms->timestamp-string]]))

(time/epoch-ms->timestamp-string ...)
(epoch-ms->timestamp-string      ...)
```

</details>

---

### epoch-s

```
@usage
(epoch-s)
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn epoch-s
  [])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [epoch-s]]))

(time/epoch-s)
(epoch-s)
```

</details>

---

### epoch-s->timestamp-string

```
@param (s) n
```

```
@example
(epoch-s->timestamp-string 1640800860)
=>
"2021-12-29T18:01:00.000Z"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn epoch-s->timestamp-string
  [n])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [epoch-s->timestamp-string]]))

(time/epoch-s->timestamp-string ...)
(epoch-s->timestamp-string      ...)
```

</details>

---

### get-date

```
@usage
(get-date)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn get-date
  [])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-date]]))

(time/get-date)
(get-date)
```

</details>

---

### get-day

```
@usage
(get-day)
```

```
@return (D)
```

<details>
<summary>Source code</summary>

```
(defn get-day
  [])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-day]]))

(time/get-day)
(get-day)
```

</details>

---

### get-hours

```
@usage
(get-hours)
```

```
@return (h)
```

<details>
<summary>Source code</summary>

```
(defn get-hours
  [])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-hours]]))

(time/get-hours)
(get-hours)
```

</details>

---

### get-hours-left-from-this-day

```
@usage
(get-hours-left-from-this-day)
```

```
@return (h)
```

<details>
<summary>Source code</summary>

```
(defn get-hours-left-from-this-day
  []
  (let [hours (get-hours)]
       (- 24 hours)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-hours-left-from-this-day]]))

(time/get-hours-left-from-this-day)
(get-hours-left-from-this-day)
```

</details>

---

### get-milliseconds

```
@usage
(get-milliseconds)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn get-milliseconds
  [])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-milliseconds]]))

(time/get-milliseconds)
(get-milliseconds)
```

</details>

---

### get-milliseconds-left-from-this-minute

```
@usage
(get-milliseconds-left-from-this-minute)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn get-milliseconds-left-from-this-minute
  []
  (let [seconds-left (get-seconds-left-from-this-minute)]
       (* 1000 seconds-left)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-milliseconds-left-from-this-minute]]))

(time/get-milliseconds-left-from-this-minute)
(get-milliseconds-left-from-this-minute)
```

</details>

---

### get-milliseconds-left-from-this-second

```
@usage
(get-milliseconds-left-from-this-second)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn get-milliseconds-left-from-this-second
  [])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-milliseconds-left-from-this-second]]))

(time/get-milliseconds-left-from-this-second)
(get-milliseconds-left-from-this-second)
```

</details>

---

### get-minutes

```
@usage
(get-minutes)
```

```
@return (m)
```

<details>
<summary>Source code</summary>

```
(defn get-minutes
  [])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-minutes]]))

(time/get-minutes)
(get-minutes)
```

</details>

---

### get-minutes-left-from-this-hour

```
@usage
(get-minutes-left-from-this-hour)
```

```
@return (m)
```

<details>
<summary>Source code</summary>

```
(defn get-minutes-left-from-this-hour
  []
  (let [minutes (get-minutes)]
       (- 60 minutes)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-minutes-left-from-this-hour]]))

(time/get-minutes-left-from-this-hour)
(get-minutes-left-from-this-hour)
```

</details>

---

### get-month

```
@usage
(get-month)
```

```
@return (M)
```

<details>
<summary>Source code</summary>

```
(defn get-month
  [])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-month]]))

(time/get-month)
(get-month)
```

</details>

---

### get-seconds

```
@usage
(get-seconds)
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn get-seconds
  [])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-seconds]]))

(time/get-seconds)
(get-seconds)
```

</details>

---

### get-seconds-left-from-this-minute

```
@usage
(get-seconds-left-from-this-minute)
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn get-seconds-left-from-this-minute
  []
  (let [seconds (get-seconds)]
       (- 60 seconds)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-seconds-left-from-this-minute]]))

(time/get-seconds-left-from-this-minute)
(get-seconds-left-from-this-minute)
```

</details>

---

### get-year

```
@usage
(get-year)
```

```
@return (Y)
```

<details>
<summary>Source code</summary>

```
(defn get-year
  []
  (.getFullYear (js/Date.)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [get-year]]))

(time/get-year)
(get-year)
```

</details>

---

### h->D

```
@param (h) n
```

```
@usage
(h->D 420)
```

```
@return (D)
```

<details>
<summary>Source code</summary>

```
(defn h->D
  [n]
  (/ n 24))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [h->D]]))

(time/h->D ...)
(h->D      ...)
```

</details>

---

### h->W

```
@param (h) n
```

```
@usage
(h->W 420)
```

```
@return (W)
```

<details>
<summary>Source code</summary>

```
(defn h->W
  [n]
  (/ n 168))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [h->W]]))

(time/h->W ...)
(h->W      ...)
```

</details>

---

### h->m

```
@param (h) n
```

```
@usage
(h->,óm 420)
```

```
@return (m)
```

<details>
<summary>Source code</summary>

```
(defn h->m
  [n]
  (* n 60))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [h->m]]))

(time/h->m ...)
(h->m      ...)
```

</details>

---

### h->ms

```
@param (h) n
```

```
@usage
(h->ms 420)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn h->ms
  [n]
  (* n 3600000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [h->ms]]))

(time/h->ms ...)
(h->ms      ...)
```

</details>

---

### h->s

```
@param (h) n
```

```
@usage
(h->s 420)
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn h->s
  [n]
  (* n 3600))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [h->s]]))

(time/h->s ...)
(h->s      ...)
```

</details>

---

### m->D

```
@param (m) n
```

```
@usage
(m->D 420)
```

```
@return (D)
```

<details>
<summary>Source code</summary>

```
(defn m->D
  [n]
  (/ n 1440))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [m->D]]))

(time/m->D ...)
(m->D      ...)
```

</details>

---

### m->W

```
@param (m) n
```

```
@usage
(m->W 420)
```

```
@return (W)
```

<details>
<summary>Source code</summary>

```
(defn m->W
  [n]
  (/ n 10800))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [m->W]]))

(time/m->W ...)
(m->W      ...)
```

</details>

---

### m->h

```
@param (m) n
```

```
@usage
(m->h 420)
```

```
@return (h)
```

<details>
<summary>Source code</summary>

```
(defn m->h
  [n]
  (/ n 60))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [m->h]]))

(time/m->h ...)
(m->h      ...)
```

</details>

---

### m->ms

```
@param (m) n
```

```
@usage
(m->ms 420)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn m->ms
  [n]
  (* n 60000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [m->ms]]))

(time/m->ms ...)
(m->ms      ...)
```

</details>

---

### m->s

```
@param (m) n
```

```
@usage
(m->s 420)
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn m->s
  [n]
  (* n 60))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [m->s]]))

(time/m->s ...)
(m->s      ...)
```

</details>

---

### ms->D

```
@param (ms) n
```

```
@usage
(ms->D 420)
```

```
@return (D)
```

<details>
<summary>Source code</summary>

```
(defn ms->D
  [n]
  (/ n 86400000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [ms->D]]))

(time/ms->D ...)
(ms->D      ...)
```

</details>

---

### ms->W

```
@param (ms) n
```

```
@usage
(ms->W 420)
```

```
@return (W)
```

<details>
<summary>Source code</summary>

```
(defn ms->W
  [n]
  (/ n 604800000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [ms->W]]))

(time/ms->W ...)
(ms->W      ...)
```

</details>

---

### ms->h

```
@param (ms) n
```

```
@usage
(ms->h 420)
```

```
@return (h)
```

<details>
<summary>Source code</summary>

```
(defn ms->h
  [n]
  (/ n 3600000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [ms->h]]))

(time/ms->h ...)
(ms->h      ...)
```

</details>

---

### ms->m

```
@param (ms) n
```

```
@usage
(ms->m 420)
```

```
@return (m)
```

<details>
<summary>Source code</summary>

```
(defn ms->m
  [n]
  (/ n 60000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [ms->m]]))

(time/ms->m ...)
(ms->m      ...)
```

</details>

---

### ms->s

```
@param (ms) n
```

```
@usage
(ms->s 420)
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn ms->s
  [n]
  (/ n 1000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [ms->s]]))

(time/ms->s ...)
(ms->s      ...)
```

</details>

---

### ms->time

```
@param (float, integer or string) n
@param (keyword)(opt) format
```

```
@example
(ms->time 260000)
=>
"00:04:20.000"
```

```
@example
(ms->time 260000.123)
=>
"00:04:20.000"
```

```
@example
(ms->time 260000 :hhmmss)
=>
"00:04:20"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn ms->time
  ([n]
   (ms->time n :hhmmssmmm))

  ([n format]
   (if n (let [hours        (format/leading-zeros      (-> n ms->h math/floor)       2)
               minutes      (format/leading-zeros (rem (-> n ms->m math/floor) 60)   2)
               seconds      (format/leading-zeros (rem (-> n ms->s math/floor) 60)   2)
               milliseconds (format/leading-zeros (rem (-> n       math/floor) 1000) 3)]
              (case format :hhmmssmmm (str hours ":" minutes ":" seconds "." milliseconds)
                           :hhmmss    (str hours ":" minutes ":" seconds))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [ms->time]]))

(time/ms->time ...)
(ms->time      ...)
```

</details>

---

### reduce-interval

```
@param (function) f
@param (collection) coll
@param (integer) interval
```

```
@example
(reduce-interval my-function [:a :b :c] 500)
=>
(set-timeout! #(my-function :a)    0)
(set-timeout! #(my-function :b)  500)
(set-timeout! #(my-function :c) 1000)
```

```
@return (*)
```

<details>
<summary>Source code</summary>

```
(defn reduce-interval
  [f coll interval]
  (letfn [(reduce-interval-f [lap item]
                             (schedule/set-timeout! #(f item)
                                                     (* lap interval))
                             (inc lap))]
         (reduce reduce-interval-f 0 coll)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [reduce-interval]]))

(time/reduce-interval ...)
(reduce-interval      ...)
```

</details>

---

### s->D

```
@param (s) n
```

```
@usage
(s->D 420)
```

```
@return (D)
```

<details>
<summary>Source code</summary>

```
(defn s->D
  [n]
  (/ n 86400))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [s->D]]))

(time/s->D ...)
(s->D      ...)
```

</details>

---

### s->W

```
@param (s) n
```

```
@usage
(s->W 420)
```

```
@return (W)
```

<details>
<summary>Source code</summary>

```
(defn s->W
  [n]
  (/ n 604800))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [s->W]]))

(time/s->W ...)
(s->W      ...)
```

</details>

---

### s->h

```
@param (s) n
```

```
@usage
(s->h 420)
```

```
@return (h)
```

<details>
<summary>Source code</summary>

```
(defn s->h
  [n]
  (/ n 3600))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [s->h]]))

(time/s->h ...)
(s->h      ...)
```

</details>

---

### s->m

```
@param (s) n
```

```
@usage
(s->m 420)
```

```
@return (m)
```

<details>
<summary>Source code</summary>

```
(defn s->m
  [n]
  (/ n 60))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [s->m]]))

(time/s->m ...)
(s->m      ...)
```

</details>

---

### s->ms

```
@param (s) n
```

```
@usage
(s->ms 420)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn s->ms
  [n]
  (* n 1000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [s->ms]]))

(time/s->ms ...)
(s->ms      ...)
```

</details>

---

### set-interval!

```
@param (function) f
@param (ms) interval
```

```
@usage
(set-interval! #(println "3 sec") 3000)
```

```
@return (integer)
```

<details>
<summary>Source code</summary>

```
(defn set-interval!
  [f interval]
  (.setInterval js/window f interval))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [set-interval!]]))

(time/set-interval! ...)
(set-interval!      ...)
```

</details>

---

### set-timeout!

```
@param (function) f
@param (ms) timeout
```

```
@usage
(set-timeout! #(println "3 sec") 3000)
```

```
@return (integer)
```

<details>
<summary>Source code</summary>

```
(defn set-timeout!
  [f timeout]
  (.setTimeout js/window f timeout))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [set-timeout!]]))

(time/set-timeout! ...)
(set-timeout!      ...)
```

</details>

---

### timestamp-object

```
@param (string)(opt) time-zone
```

```
@usage
(timestamp-object)
```

```
@usage
(timestamp-object "Europe/Budapest")
```

```
@return (object)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object
  ([])

  ([time-zone]))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-object]]))

(time/timestamp-object ...)
(timestamp-object      ...)
```

</details>

---

### timestamp-object->day

```
@param (object) n
```

```
@example
(timestamp->day #<DateTime 2020-04-20T16:20:00.123Z>)
=>
20
```

```
@return (D)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->day
  [n]
  (cljs-time.core/day n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-object->day]]))

(time/timestamp-object->day ...)
(timestamp-object->day      ...)
```

</details>

---

### timestamp-object->hours

```
@param (object) n
```

```
@example
(timestamp->hours #<DateTime 2020-04-20T16:20:00.123Z>)
=>
16
```

```
@return (h)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->hours
  [n]
  (cljs-time.core/hours n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-object->hours]]))

(time/timestamp-object->hours ...)
(timestamp-object->hours      ...)
```

</details>

---

### timestamp-object->milliseconds

```
@param (object) n
```

```
@example
(timestamp->milliseconds #<DateTime 2020-04-20T16:20:00.123Z>)
=>
123
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->milliseconds
  [n]
  (cljs-time.core/milli n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-object->milliseconds]]))

(time/timestamp-object->milliseconds ...)
(timestamp-object->milliseconds      ...)
```

</details>

---

### timestamp-object->minutes

```
@param (object) n
```

```
@example
(timestamp->minutes #<DateTime 2020-04-20T16:20:00.123Z>)
=>
20
```

```
@return (m)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->minutes
  [n]
  (cljs-time.core/minutes n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-object->minutes]]))

(time/timestamp-object->minutes ...)
(timestamp-object->minutes      ...)
```

</details>

---

### timestamp-object->month

```
@param (object) n
```

```
@example
(timestamp->month #<DateTime 2020-04-20T16:20:00.123Z>)
=>
4
```

```
@return (M)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->month
  [n]
  (cljs-time.core/month n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-object->month]]))

(time/timestamp-object->month ...)
(timestamp-object->month      ...)
```

</details>

---

### timestamp-object->seconds

```
@param (object) n
```

```
@example
(timestamp->seconds #<DateTime 2020-04-20T16:20:00.123Z>)
=>
0
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->seconds
  [n]
  (cljs-time.core/seconds n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-object->seconds]]))

(time/timestamp-object->seconds ...)
(timestamp-object->seconds      ...)
```

</details>

---

### timestamp-object->year

```
@param (object) n
```

```
@example
(timestamp->year #<DateTime 2020-04-20T16:20:00.123Z>)
=>
2020
```

```
@return (Y)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->year
  [n]
  (cljs-time.core/year n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-object->year]]))

(time/timestamp-object->year ...)
(timestamp-object->year      ...)
```

</details>

---

### timestamp-object?

```
@param (*) n
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object?
  [n])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-object?]]))

(time/timestamp-object? ...)
(timestamp-object?      ...)
```

</details>

---

### timestamp-string

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string
  []
  (let [formatter (cljs-time.format/formatter "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        timestamp (cljs-time.core/now)]
       (cljs-time.format/unparse formatter timestamp)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string]]))

(time/timestamp-string)
(timestamp-string)
```

</details>

---

### timestamp-string->date

```
@param (string) n
@param (keyword)(opt) format
```

```
@example
(timestamp-string->date "2020-04-20T16:20:00.123Z" :yyyymmdd)
=>
"2020-04-20"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->date
  ([n]
   (timestamp-string->date n :yyyymmdd))

  ([n format]
   (if (string/nonempty? n)
       (let [year  (timestamp-string->year n)
             month (format/leading-zeros (timestamp-string->month n) 2)
             day   (format/leading-zeros (timestamp-string->day   n) 2)]
            (case format :yyyymmdd (str year "-" month "-" day)
                         :yymmdd   (let [year (string/part year 2 2)]
                                        (str year "-" month "-" day))
                         (return n))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string->date]]))

(time/timestamp-string->date ...)
(timestamp-string->date      ...)
```

</details>

---

### timestamp-string->date-time

```
@param (string) n
@param (keyword)(opt) date-format
@param (keyword)(opt) time-format
```

```
@example
(timestamp->date-time "2020-04-20T16:20:00.123Z" :yyyymmdd :hhmmss)
=>
"2020-04-20 - 16:20:00"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->date-time
  ([n]
   (timestamp-string->date-time n :yyyymmdd :hhmmss))

  ([n time-format]
   (timestamp-string->date-time n :yyyymmdd time-format))

  ([n date-format time-format]
   (if (string/nonempty? n)
       (let [date (timestamp-string->date n date-format)
             time (timestamp-string->time n time-format)]
            (str date " - " time)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string->date-time]]))

(time/timestamp-string->date-time ...)
(timestamp-string->date-time      ...)
```

</details>

---

### timestamp-string->day

```
@param (string) n
```

```
@example
(timestamp-string->day "2020-04-20T16:20:00.123Z")
=>
"20"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->day
  [n]
  (string/part n 8 10))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string->day]]))

(time/timestamp-string->day ...)
(timestamp-string->day      ...)
```

</details>

---

### timestamp-string->hours

```
@param (string) n
```

```
@example
(timestamp-string->hours "2020-04-20T16:20:00.123Z")
=>
"16"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->hours
  [n]
  (string/part n 11 13))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string->hours]]))

(time/timestamp-string->hours ...)
(timestamp-string->hours      ...)
```

</details>

---

### timestamp-string->milliseconds

```
@param (string) n
```

```
@example
(timestamp->milliseconds "2020-04-20T16:20:00.123Z")
=>
"123"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->milliseconds
  [n]
  (string/part n 20 23))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string->milliseconds]]))

(time/timestamp-string->milliseconds ...)
(timestamp-string->milliseconds      ...)
```

</details>

---

### timestamp-string->minutes

```
@param (string) n
```

```
@example
(timestamp-string->minutes "2020-04-20T16:20:00.123Z")
=>
"20"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->minutes
  [n]
  (string/part n 14 16))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string->minutes]]))

(time/timestamp-string->minutes ...)
(timestamp-string->minutes      ...)
```

</details>

---

### timestamp-string->month

```
@param (string) n
```

```
@example
(timestamp-string->month "2020-04-20T16:20:00.123Z")
=>
"04"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->month
  [n]
  (string/part n 5 7))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string->month]]))

(time/timestamp-string->month ...)
(timestamp-string->month      ...)
```

</details>

---

### timestamp-string->seconds

```
@param (string) n
```

```
@example
(timestamp->seconds "2020-04-20T16:20:00.123Z")
=>
"00"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->seconds
  [n]
  (string/part n 17 19))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string->seconds]]))

(time/timestamp-string->seconds ...)
(timestamp-string->seconds      ...)
```

</details>

---

### timestamp-string->time

```
@param (string) n
@param (keyword)(opt) format
```

```
@example
(timestamp-string->time "2020-04-20T16:20:00.123Z" :hhmmss)
=>
"16:20:00"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->time
  ([n]
   (timestamp-string->time n :hhmmss))

  ([n format]
   (if (string/nonempty? n)
       (let [hours   (format/leading-zeros (timestamp-string->hours   n) 2)
             minutes (format/leading-zeros (timestamp-string->minutes n) 2)
             seconds (format/leading-zeros (timestamp-string->seconds n) 2)]
            (case format :hhmmss (str hours ":" minutes ":" seconds)
                         :hhmm   (str hours ":" minutes)
                         (return n))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string->time]]))

(time/timestamp-string->time ...)
(timestamp-string->time      ...)
```

</details>

---

### timestamp-string->today?

```
@param (string) n
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->today?
  [n]
  (let [x (timestamp-string)]
       (= (string/part n 0 10)
          (string/part x 0 10))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string->today?]]))

(time/timestamp-string->today? ...)
(timestamp-string->today?      ...)
```

</details>

---

### timestamp-string->year

```
@param (string) n
```

```
@example
(timestamp-string->year "2020-04-20T16:20:00.123Z")
=>
"2020"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->year
  [n]
  (string/part n 0 4))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string->year]]))

(time/timestamp-string->year ...)
(timestamp-string->year      ...)
```

</details>

---

### timestamp-string?

```
@param (*) n
```

```
@example
(timestamp-string? "2020-04-20T20:00.123+00:00")
=>
true
```

```
@example
(timestamp-string? "2020-04-20T16:20:00.123Z")
=>
true
```

```
@example
(timestamp-string? "2020-04-20T16:20:00.123")
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string?
  [n]
  (and (string? n)
       (or (re-matches #"\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}.\d{3}\+\d{2}:\d{2}" n)
           (re-matches #"\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}.\d{3}Z"             n)
           (re-matches #"\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}.\d{3}"              n))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :as time :refer [timestamp-string?]]))

(time/timestamp-string? ...)
(timestamp-string?      ...)
```

</details>
