
### time.api

Functional documentation of the time.api isomorphic namespace

---

##### [README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > time.api

### Index

- [clear-interval!](#clear-interval)

- [current-date](#current-date)

- [current-day](#current-day)

- [current-hour](#current-hour)

- [current-millisecond](#current-millisecond)

- [current-minute](#current-minute)

- [current-month](#current-month)

- [current-second](#current-second)

- [current-week](#current-week)

- [current-year](#current-year)

- [date->epoch-ms](#date-epoch-ms)

- [date-contains-epoch-ms?](#date-contains-epoch-ms)

- [date-ends-after-epoch-ms?](#date-ends-after-epoch-ms)

- [date-ends-before-epoch-ms?](#date-ends-before-epoch-ms)

- [date-starts-after-epoch-ms?](#date-starts-after-epoch-ms)

- [date-starts-before-epoch-ms?](#date-starts-before-epoch-ms)

- [date-string?](#date-string)

- [elapsed](#elapsed)

- [epoch-ms](#epoch-ms)

- [epoch-ms->date](#epoch-ms-date)

- [epoch-ms->timestamp-string](#epoch-ms-timestamp-string)

- [epoch-ms-age](#epoch-ms-age)

- [epoch-s](#epoch-s)

- [epoch-s->timestamp-string](#epoch-s-timestamp-string)

- [epoch-s-age](#epoch-s-age)

- [h->D](#h-d)

- [h->W](#h-w)

- [h->m](#h-m)

- [h->ms](#h-ms)

- [h->s](#h-s)

- [hours-left-from-current-day](#hours-left-from-current-day)

- [m->D](#m-d)

- [m->W](#m-w)

- [m->h](#m-h)

- [m->ms](#m-ms)

- [m->s](#m-s)

- [milliseconds-left-from-current-minute](#milliseconds-left-from-current-minute)

- [milliseconds-left-from-current-second](#milliseconds-left-from-current-second)

- [minutes-left-from-current-hour](#minutes-left-from-current-hour)

- [ms->D](#ms-d)

- [ms->W](#ms-w)

- [ms->h](#ms-h)

- [ms->m](#ms-m)

- [ms->s](#ms-s)

- [ms->time](#ms-time)

- [parse-date](#parse-date)

- [parse-timestamp](#parse-timestamp)

- [parse-timestamps](#parse-timestamps)

- [reduce-interval](#reduce-interval)

- [s->D](#s-d)

- [s->W](#s-w)

- [s->h](#s-h)

- [s->m](#s-m)

- [s->ms](#s-ms)

- [seconds-left-from-current-minute](#seconds-left-from-current-minute)

- [set-interval!](#set-interval)

- [set-timeout!](#set-timeout)

- [timestamp-object](#timestamp-object)

- [timestamp-object->day](#timestamp-object-day)

- [timestamp-object->elapsed-ms](#timestamp-object-elapsed-ms)

- [timestamp-object->elapsed-s](#timestamp-object-elapsed-s)

- [timestamp-object->epoch-ms](#timestamp-object-epoch-ms)

- [timestamp-object->epoch-s](#timestamp-object-epoch-s)

- [timestamp-object->hours](#timestamp-object-hours)

- [timestamp-object->milliseconds](#timestamp-object-milliseconds)

- [timestamp-object->minutes](#timestamp-object-minutes)

- [timestamp-object->month](#timestamp-object-month)

- [timestamp-object->seconds](#timestamp-object-seconds)

- [timestamp-object->week](#timestamp-object-week)

- [timestamp-object->year](#timestamp-object-year)

- [timestamp-object?](#timestamp-object)

- [timestamp-string](#timestamp-string)

- [timestamp-string->date](#timestamp-string-date)

- [timestamp-string->date-time](#timestamp-string-date-time)

- [timestamp-string->day](#timestamp-string-day)

- [timestamp-string->elapsed-ms](#timestamp-string-elapsed-ms)

- [timestamp-string->elapsed-s](#timestamp-string-elapsed-s)

- [timestamp-string->epoch-ms](#timestamp-string-epoch-ms)

- [timestamp-string->epoch-s](#timestamp-string-epoch-s)

- [timestamp-string->hours](#timestamp-string-hours)

- [timestamp-string->milliseconds](#timestamp-string-milliseconds)

- [timestamp-string->minutes](#timestamp-string-minutes)

- [timestamp-string->month](#timestamp-string-month)

- [timestamp-string->seconds](#timestamp-string-seconds)

- [timestamp-string->time](#timestamp-string-time)

- [timestamp-string->today?](#timestamp-string-today)

- [timestamp-string->week](#timestamp-string-week)

- [timestamp-string->year](#timestamp-string-year)

- [timestamp-string?](#timestamp-string)

- [unparse-timestamp](#unparse-timestamp)

- [unparse-timestamps](#unparse-timestamps)

---

### clear-interval!

```
@param (integer) interval-id
```

```
@return (clj: ?, cljs: integer)
```

<details>
<summary>Source code</summary>

```
(defn clear-interval!
  [interval-id]
  #?(:cljs (.clearInterval js/window interval-id)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [clear-interval!]]))

(time.api/clear-interval! ...)
(clear-interval!          ...)
```

</details>

---

### current-date

```
@description
Returns the actual date.
```

```
@usage
(current-date)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn current-date
  []
  (-> (timestamp/timestamp-string)
      (timestamp/timestamp-string->date)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [current-date]]))

(time.api/current-date)
(current-date)
```

</details>

---

### current-day

```
@description
Returns the actual day.
```

```
@usage
(current-day)
```

```
@return (D)
```

<details>
<summary>Source code</summary>

```
(defn current-day
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->day)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [current-day]]))

(time.api/current-day)
(current-day)
```

</details>

---

### current-hour

```
@description
Returns the actual hour.
```

```
@usage
(current-hour)
```

```
@return (h)
```

<details>
<summary>Source code</summary>

```
(defn current-hour
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->hours)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [current-hour]]))

(time.api/current-hour)
(current-hour)
```

</details>

---

### current-millisecond

```
@description
Returns the actual millisecond.
```

```
@usage
(current-millisecond)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn current-millisecond
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->milliseconds)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [current-millisecond]]))

(time.api/current-millisecond)
(current-millisecond)
```

</details>

---

### current-minute

```
@description
Returns the actual minute.
```

```
@usage
(current-minute)
```

```
@return (m)
```

<details>
<summary>Source code</summary>

```
(defn current-minute
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->minutes)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [current-minute]]))

(time.api/current-minute)
(current-minute)
```

</details>

---

### current-month

```
@description
Returns the actual month.
```

```
@usage
(current-month)
```

```
@return (M)
```

<details>
<summary>Source code</summary>

```
(defn current-month
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->month)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [current-month]]))

(time.api/current-month)
(current-month)
```

</details>

---

### current-second

```
@description
Returns the actual second.
```

```
@usage
(current-second)
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn current-second
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->seconds)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [current-second]]))

(time.api/current-second)
(current-second)
```

</details>

---

### current-week

```
@description
Returns the actual week.
```

```
@usage
(current-week)
```

```
@return (W)
```

<details>
<summary>Source code</summary>

```
(defn current-week
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->week)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [current-week]]))

(time.api/current-week)
(current-week)
```

</details>

---

### current-year

```
@description
Returns the actual year.
```

```
@usage
(current-year)
```

```
@return (Y)
```

<details>
<summary>Source code</summary>

```
(defn current-year
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->year)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [current-year]]))

(time.api/current-year)
(current-year)
```

</details>

---

### date->epoch-ms

```
@description
Converts the given date string to an epoch milliseconds value.
```

```
@param (string) date
```

```
@usage
(date->epoch-ms "2020-04-20")
```

```
@example
(date->epoch-ms "2020-04-20")
=>
1587340800000
```

```
@return (ms)
The very first millisec of the given date.
```

<details>
<summary>Source code</summary>

```
(defn date->epoch-ms
  [date]
  (-> date (str "T00:00:00.000Z") timestamp-string->epoch-ms))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [date->epoch-ms]]))

(time.api/date->epoch-ms ...)
(date->epoch-ms          ...)
```

</details>

---

### date-contains-epoch-ms?

```
@description
Returns TRUE if the given epoch milliseconds value is ...
... >= the first ms of the given date string,
... <= the last ms of the given date string.
```

```
@param (string) date
@param (ms) epoch-ms
```

```
@usage
(date-contains-epoch-ms? "2020-04-20" 1587344200000)
```

```
@example
(date-contains-epoch-ms? "2020-04-20" 1587344200000)
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn date-contains-epoch-ms?
  [date epoch-ms]
  (let [date-start-ms (date->epoch-ms date)
        date-end-ms   (+ date-start-ms 86399999)]
       (and (>= epoch-ms date-start-ms)
            (<= epoch-ms date-end-ms))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [date-contains-epoch-ms?]]))

(time.api/date-contains-epoch-ms? ...)
(date-contains-epoch-ms?          ...)
```

</details>

---

### date-ends-after-epoch-ms?

```
@description
Returns TRUE if the given epoch milliseconds value is ...
... <= the last ms of the given date string.
```

```
@param (string) date
@param (ms) epoch-ms
```

```
@usage
(date-ends-after-epoch-ms? "2020-04-20" 1587344200000)
```

```
@example
(date-ends-after-epoch-ms? "2020-04-20" 1587344200000)
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn date-ends-after-epoch-ms?
  [date epoch-ms]
  (let [date-start-ms (date->epoch-ms date)
        date-end-ms   (+ date-start-ms 86399999)]
       (<= epoch-ms date-end-ms)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [date-ends-after-epoch-ms?]]))

(time.api/date-ends-after-epoch-ms? ...)
(date-ends-after-epoch-ms?          ...)
```

</details>

---

### date-ends-before-epoch-ms?

```
@description
Returns TRUE if the given epoch milliseconds value is ...
... > the last ms of the given date string.
```

```
@param (string) date
@param (ms) epoch-ms
```

```
@usage
(date-ends-before-epoch-ms? "2020-04-19" 1587344200000)
```

```
@example
(date-ends-before-epoch-ms? "2020-04-19" 1587344200000)
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn date-ends-before-epoch-ms?
  [date epoch-ms]
  (let [date-start-ms (date->epoch-ms date)
        date-end-ms   (+ date-start-ms 86399999)]
       (> epoch-ms date-end-ms)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [date-ends-before-epoch-ms?]]))

(time.api/date-ends-before-epoch-ms? ...)
(date-ends-before-epoch-ms?          ...)
```

</details>

---

### date-starts-after-epoch-ms?

```
@description
Returns TRUE if the given epoch milliseconds value is ...
... < the first ms of the given date string.
```

```
@param (string) date
@param (ms) epoch-ms
```

```
@usage
(date-starts-after-epoch-ms? "2020-04-21" 1587344200000)
```

```
@example
(date-starts-after-epoch-ms? "2020-04-21" 1587344200000)
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn date-starts-after-epoch-ms?
  [date epoch-ms]
  (let [date-start-ms (date->epoch-ms date)]
       (< epoch-ms date-start-ms)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [date-starts-after-epoch-ms?]]))

(time.api/date-starts-after-epoch-ms? ...)
(date-starts-after-epoch-ms?          ...)
```

</details>

---

### date-starts-before-epoch-ms?

```
@description
Returns TRUE if the given epoch milliseconds value is ...
... >= the first ms of the given date string.
```

```
@param (string) date
@param (ms) epoch-ms
```

```
@usage
(date-starts-before-epoch-ms? "2020-04-20" 1587344200000)
```

```
@example
(date-starts-before-epoch-ms? "2020-04-20" 1587344200000)
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn date-starts-before-epoch-ms?
  [date epoch-ms]
  (let [date-start-ms (date->epoch-ms date)]
       (>= epoch-ms date-start-ms)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [date-starts-before-epoch-ms?]]))

(time.api/date-starts-before-epoch-ms? ...)
(date-starts-before-epoch-ms?          ...)
```

</details>

---

### date-string?

```
@description
Returns TRUE if the given 'n' value is a date string.
```

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
(ns my-namespace (:require [time.api :refer [date-string?]]))

(time.api/date-string? ...)
(date-string?          ...)
```

</details>

---

### elapsed

```
@description
Returns a high resolution timestamp in milliseconds that represents the time elapsed since
the time when navigation has started in window contexts, or the time when the worker is run
in Worker and ServiceWorker contexts.
```

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
  #?(:cljs (.now js/performance)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [elapsed]]))

(time.api/elapsed)
(elapsed)
```

</details>

---

### epoch-ms

```
@description
Returns the actual epoch milliseconds.
```

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
  []
  #?(:clj (-> (clj-time.core/now)
              (clj-time.coerce/to-long))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [epoch-ms]]))

(time.api/epoch-ms)
(epoch-ms)
```

</details>

---

### epoch-ms->date

```
@description
Converts the given epoch milliseconds value to a date string.
```

```
@param (ms) epoch-ms
```

```
@usage
(epoch-ms->date 1587340800000)
```

```
@example
(epoch-ms->date 1587340800000)
=>
"2020-04-20"
```

```
@return (string)
The date that contains the given epoch-ms.
```

<details>
<summary>Source code</summary>

```
(defn epoch-ms->date
  [epoch-ms]
  (-> epoch-ms epoch-ms->timestamp-string (string/part 0 10)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [epoch-ms->date]]))

(time.api/epoch-ms->date ...)
(epoch-ms->date          ...)
```

</details>

---

### epoch-ms->timestamp-string

```
@description
Converts the given epoch milliseconds to timestamp string.
```

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
  [n]
  #?(:clj (if n (-> n clj-time.coerce/from-long str))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [epoch-ms->timestamp-string]]))

(time.api/epoch-ms->timestamp-string ...)
(epoch-ms->timestamp-string          ...)
```

</details>

---

### epoch-ms-age

```
@description
Returns how many milliseconds elapsed since the given epoch milliseconds.
```

```
@param (ms) n
```

```
@example
(epoch-ms-age 1640800860000)
=>
420000
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn epoch-ms-age
  [n]
  (- (epoch-ms) n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [epoch-ms-age]]))

(time.api/epoch-ms-age ...)
(epoch-ms-age          ...)
```

</details>

---

### epoch-s

```
@description
Returns the actual epoch seconds.
```

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
  []
  #?(:clj (-> (clj-time.core/now)
              (clj-time.coerce/to-long)
              (quot 1000))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [epoch-s]]))

(time.api/epoch-s)
(epoch-s)
```

</details>

---

### epoch-s->timestamp-string

```
@description
Converts the given epoch seconds to timestamp string.
```

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
  [n]
  #?(:clj (if n (-> n convert/s->ms clj-time.coerce/from-long str))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [epoch-s->timestamp-string]]))

(time.api/epoch-s->timestamp-string ...)
(epoch-s->timestamp-string          ...)
```

</details>

---

### epoch-s-age

```
@description
Returns how many seconds elapsed since the given epoch seconds.
```

```
@param (s) n
```

```
@example
(epoch-s-age 1640800860)
=>
420
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn epoch-s-age
  [n]
  (- (epoch-s) n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [epoch-s-age]]))

(time.api/epoch-s-age ...)
(epoch-s-age          ...)
```

</details>

---

### h->D

```
@description
Converts the given hours to days.
```

```
@param (h) n
```

```
@usage
(h->D 420)
```

```
@example
(h->D 420)
=>
17.5
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
(ns my-namespace (:require [time.api :refer [h->D]]))

(time.api/h->D ...)
(h->D          ...)
```

</details>

---

### h->W

```
@description
Converts the given hours to weeks.
```

```
@param (h) n
```

```
@usage
(h->W 420)
```

```
@example
(h->W 420)
=>
2.5
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
(ns my-namespace (:require [time.api :refer [h->W]]))

(time.api/h->W ...)
(h->W          ...)
```

</details>

---

### h->m

```
@description
Converts the given hours to minutes.
```

```
@param (h) n
```

```
@usage
(h->m 420)
```

```
@example
(h->m 420)
=>
25200
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
(ns my-namespace (:require [time.api :refer [h->m]]))

(time.api/h->m ...)
(h->m          ...)
```

</details>

---

### h->ms

```
@description
Converts the given hours to milliseconds.
```

```
@param (h) n
```

```
@usage
(h->ms 420)
```

```
@example
(h->ms 420)
=>
1521000000
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
(ns my-namespace (:require [time.api :refer [h->ms]]))

(time.api/h->ms ...)
(h->ms          ...)
```

</details>

---

### h->s

```
@description
Converts the given hours to seconds.
```

```
@param (h) n
```

```
@usage
(h->s 420)
```

```
@example
(h->s 420)
=>
1512000
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
(ns my-namespace (:require [time.api :refer [h->s]]))

(time.api/h->s ...)
(h->s          ...)
```

</details>

---

### hours-left-from-current-day

```
@description
Returns how many hours left from the actual day.
```

```
@usage
(hours-left-from-current-day)
```

```
@return (h)
```

<details>
<summary>Source code</summary>

```
(defn hours-left-from-current-day
  []
  (let [current-hour (current-hour)]
       (- 24 current-hour)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [hours-left-from-current-day]]))

(time.api/hours-left-from-current-day)
(hours-left-from-current-day)
```

</details>

---

### m->D

```
@description
Converts the given minutes to days.
```

```
@param (m) n
```

```
@usage
(m->h 420)
```

```
@example
(m->h 420)
=>
0.291666'
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
(ns my-namespace (:require [time.api :refer [m->D]]))

(time.api/m->D ...)
(m->D          ...)
```

</details>

---

### m->W

```
@description
Converts the given minutes to weeks.
```

```
@param (m) n
```

```
@usage
(m->W 420)
```

```
@example
(m->W 420)
=>
0.3888'
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
(ns my-namespace (:require [time.api :refer [m->W]]))

(time.api/m->W ...)
(m->W          ...)
```

</details>

---

### m->h

```
@description
Converts the given minutes to hours.
```

```
@param (m) n
```

```
@usage
(m->h 420)
```

```
@example
(m->h 420)
=>
7
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
(ns my-namespace (:require [time.api :refer [m->h]]))

(time.api/m->h ...)
(m->h          ...)
```

</details>

---

### m->ms

```
@description
Converts the given minutes to milliseconds.
```

```
@param (m) n
```

```
@usage
(m->ms 420)
```

```
@example
(m->ms 420)
=>
25200000
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
(ns my-namespace (:require [time.api :refer [m->ms]]))

(time.api/m->ms ...)
(m->ms          ...)
```

</details>

---

### m->s

```
@description
Converts the given minutes to seconds.
```

```
@param (m) n
```

```
@usage
(m->s 420)
```

```
@example
(m->s 420)
=>
25200
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
(ns my-namespace (:require [time.api :refer [m->s]]))

(time.api/m->s ...)
(m->s          ...)
```

</details>

---

### milliseconds-left-from-current-minute

```
@description
Returns how many milliseconds left from the actual minute.
```

```
@usage
(milliseconds-left-from-current-minute)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn milliseconds-left-from-current-minute
  []
  (let [seconds-left-from-current-minute (seconds-left-from-current-minute)]
       (* 1000 seconds-left-from-current-minute)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [milliseconds-left-from-current-minute]]))

(time.api/milliseconds-left-from-current-minute)
(milliseconds-left-from-current-minute)
```

</details>

---

### milliseconds-left-from-current-second

```
@description
Returns how many milliseconds left from the actual second.
```

```
@usage
(milliseconds-left-from-current-second)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn milliseconds-left-from-current-second
  []
  (let [current-millisecond (current-millisecond)]
       (- 1000 current-millisecond)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [milliseconds-left-from-current-second]]))

(time.api/milliseconds-left-from-current-second)
(milliseconds-left-from-current-second)
```

</details>

---

### minutes-left-from-current-hour

```
@description
Returns how many minutes left from the actual hour.
```

```
@usage
(minutes-left-from-current-hour)
```

```
@return (m)
```

<details>
<summary>Source code</summary>

```
(defn minutes-left-from-current-hour
  []
  (let [current-minute (current-minute)]
       (- 60 current-minute)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [minutes-left-from-current-hour]]))

(time.api/minutes-left-from-current-hour)
(minutes-left-from-current-hour)
```

</details>

---

### ms->D

```
@description
Converts the given milliseconds to days.
```

```
@param (ms) n
```

```
@usage
(ms->D 420)
```

```
@example
(ms->D 420)
=>
0.00000486111'
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
(ns my-namespace (:require [time.api :refer [ms->D]]))

(time.api/ms->D ...)
(ms->D          ...)
```

</details>

---

### ms->W

```
@description
Converts the given milliseconds to weeks.
```

```
@param (ms) n
```

```
@usage
(ms->W 420)
```

```
@example
(ms->W 420)
=>
0.00000069444'
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
(ns my-namespace (:require [time.api :refer [ms->W]]))

(time.api/ms->W ...)
(ms->W          ...)
```

</details>

---

### ms->h

```
@description
Converts the given milliseconds to hours.
```

```
@param (ms) n
```

```
@usage
(ms->h 420)
```

```
@example
(ms->h 420)
=>
0.00011666'
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
(ns my-namespace (:require [time.api :refer [ms->h]]))

(time.api/ms->h ...)
(ms->h          ...)
```

</details>

---

### ms->m

```
@description
Converts the given milliseconds to minutes.
```

```
@param (ms) n
```

```
@usage
(ms->m 420)
```

```
@example
(ms->m 420)
=>
0.007
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
(ns my-namespace (:require [time.api :refer [ms->m]]))

(time.api/ms->m ...)
(ms->m          ...)
```

</details>

---

### ms->s

```
@description
Converts the given milliseconds to seconds.
```

```
@param (ms) n
```

```
@usage
(ms->s 420)
```

```
@example
(ms->s 420)
=>
0.42
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
(ns my-namespace (:require [time.api :refer [ms->s]]))

(time.api/ms->s ...)
(ms->s          ...)
```

</details>

---

### ms->time

```
@description
Converts the given milliseconds to time string.
```

```
@param (float, integer or string) n
@param (keyword)(opt) format
:hhmm, :hhmmss, :hhmmssmmm
Default: :hhmmssmmm
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
               minutes      (format/leading-zeros (rem (-> n ms->m math/floor)   60) 2)
               seconds      (format/leading-zeros (rem (-> n ms->s math/floor)   60) 2)
               milliseconds (format/leading-zeros (rem (-> n       math/floor) 1000) 3)]
              (case format :hhmmssmmm (str hours":"minutes":"seconds"."milliseconds)
                           :hhmmss    (str hours":"minutes":"seconds)
                           :hhmm      (str hours":"minutes))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [ms->time]]))

(time.api/ms->time ...)
(ms->time          ...)
```

</details>

---

### parse-date

```
@description
Converts the given date string to timestamp object.
```

```
@param (string) n
```

```
@example
(parse-date "2020-04-20")
=>
#<DateTime 2020-04-20T00:00:00.000Z>
```

```
@return (object)
```

<details>
<summary>Source code</summary>

```
(defn parse-date
  [n]
  #?(:clj (try (let [formatter (clj-time.format/formatter "yyyy-MM-dd")]
                    (clj-time.format/parse formatter n))
               (catch Exception e (println e)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [parse-date]]))

(time.api/parse-date ...)
(parse-date          ...)
```

</details>

---

### parse-timestamp

```
@description
Converts the given timestamp string to timestamp object.
```

```
@param (string) n
```

```
@example
(parse-timestamp "2020-04-20T16:20:00.123")
=>
#<DateTime 2020-04-20T16:20:00.123Z>
```

```
@return (object)
```

<details>
<summary>Source code</summary>

```
(defn parse-timestamp
  [n]
  #?(:clj (try (let [formatter (clj-time.format/formatters :date-time)]
                    (clj-time.format/parse formatter n))
               (catch Exception e (println e)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [parse-timestamp]]))

(time.api/parse-timestamp ...)
(parse-timestamp          ...)
```

</details>

---

### parse-timestamps

```
@description
Converts the timestamp strings in the given data structure to timestamp objects.
```

```
@param (*) n
```

```
@example
(parse-timestamps {:my-timestamp "2020-04-20T16:20:00.123Z"})
=>
{:my-timestamp #<DateTime 2020-04-20T16:20:00.123Z>}
```

```
@return (*)
```

<details>
<summary>Source code</summary>

```
(defn parse-timestamps
  [n]
  (cond (timestamp/date-string?      n) (parse-date      n)
        (timestamp/timestamp-string? n) (parse-timestamp n)
        (map?                        n) (map/->values    n parse-timestamps)
        (vector?                     n) (vector/->items  n parse-timestamps)
        :return n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [parse-timestamps]]))

(time.api/parse-timestamps ...)
(parse-timestamps          ...)
```

</details>

---

### reduce-interval

```
@description
Iterates over the given 'coll' collection and applies the given 'f' function on each item
while taking an 'interval' long pause between them.
```

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
(ns my-namespace (:require [time.api :refer [reduce-interval]]))

(time.api/reduce-interval ...)
(reduce-interval          ...)
```

</details>

---

### s->D

```
@description
Converts the given seconds to milliseconds.
```

```
@param (s) n
```

```
@usage
(s->D 420)
```

```
@example
(s->D 420)
=>
0.00486111'
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
(ns my-namespace (:require [time.api :refer [s->D]]))

(time.api/s->D ...)
(s->D          ...)
```

</details>

---

### s->W

```
@description
Converts the given seconds to milliseconds.
```

```
@param (s) n
```

```
@usage
(s->W 420)
```

```
@example
(s->W 420)
=>
0.00069444'
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
(ns my-namespace (:require [time.api :refer [s->W]]))

(time.api/s->W ...)
(s->W          ...)
```

</details>

---

### s->h

```
@description
Converts the given seconds to milliseconds.
```

```
@param (s) n
```

```
@usage
(s->h 420)
```

```
@example
(s->h 420)
=>
0.11666'
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
(ns my-namespace (:require [time.api :refer [s->h]]))

(time.api/s->h ...)
(s->h          ...)
```

</details>

---

### s->m

```
@description
Converts the given seconds to milliseconds.
```

```
@param (s) n
```

```
@usage
(s->m 420)
```

```
@example
(s->m 420)
=>
7
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
(ns my-namespace (:require [time.api :refer [s->m]]))

(time.api/s->m ...)
(s->m          ...)
```

</details>

---

### s->ms

```
@description
Converts the given seconds to milliseconds.
```

```
@param (s) n
```

```
@usage
(s->ms 420)
```

```
@example
(s->ms 420)
=>
420000
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
(ns my-namespace (:require [time.api :refer [s->ms]]))

(time.api/s->ms ...)
(s->ms          ...)
```

</details>

---

### seconds-left-from-current-minute

```
@description
Returns how many seconds left from the actual minute.
```

```
@usage
(seconds-left-from-current-minute)
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn seconds-left-from-current-minute
  []
  (let [current-second (current-second)]
       (- 60 current-second)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [seconds-left-from-current-minute]]))

(time.api/seconds-left-from-current-minute)
(seconds-left-from-current-minute)
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
@return (clj: tea_time.core.Every object, cljs: integer)
```

<details>
<summary>Source code</summary>

```
(defn set-interval!
  [f interval]
  #?(:clj  (tea-time.core/every! (convert/ms->s interval) 0 f)
     :cljs (.setInterval js/window f interval)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [set-interval!]]))

(time.api/set-interval! ...)
(set-interval!          ...)
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
@return (clj: tea_time.core.Once object, cljs: integer)
```

<details>
<summary>Source code</summary>

```
(defn set-timeout!
  [f timeout]
  #?(:clj  (tea-time.core/after! (convert/ms->s timeout) f)
     :cljs (.setTimeout js/window f timeout)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [set-timeout!]]))

(time.api/set-timeout! ...)
(set-timeout!          ...)
```

</details>

---

### timestamp-object

```
@description
Returns a timestamp object.
```

```
@param (string)(opt) time-zone
```

```
@example
(timestamp-object)
=>
#<DateTime 2020-04-20T16:20:00.123Z>
```

```
@example
(timestamp-object "Europe/Budapest")
=>
#<DateTime 2020-04-20T16:20:00.123+02:00>
```

```
@return (object)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object
  ([]
   #?(:clj  (clj-time.core/now)
      :cljs (cljs-time.core/now)))

  ([time-zone]
   #?(:clj (let [timestamp (clj-time.core/now)
                 time-zone (clj-time.core/time-zone-for-id time-zone)]
                (clj-time.core/to-time-zone timestamp time-zone)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object]]))

(time.api/timestamp-object ...)
(timestamp-object          ...)
```

</details>

---

### timestamp-object->day

```
@description
Converts the given timestamp object to day.
```

```
@param (object) n
```

```
@example
(timestamp-object->day #<DateTime 2020-04-20T16:20:00.123Z>)
=>
20
```

```
@return (integer)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->day
  [n]
  #?(:clj  (clj-time.core/day  n)
     :cljs (cljs-time.core/day n)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object->day]]))

(time.api/timestamp-object->day ...)
(timestamp-object->day          ...)
```

</details>

---

### timestamp-object->elapsed-ms

```
@description
Returns how many milliseconds elapsed since the given timestamp object.
```

```
@param (string) n
```

```
@usage
(timestamp-object->elapsed-ms #<DateTime 2020-04-20T16:20:00.123Z>)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->elapsed-ms
  [n]
  (let [epoch-ms (epoch/epoch-ms)]
       (->> n epoch/timestamp-object->epoch-ms (- epoch-ms))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object->elapsed-ms]]))

(time.api/timestamp-object->elapsed-ms ...)
(timestamp-object->elapsed-ms          ...)
```

</details>

---

### timestamp-object->elapsed-s

```
@description
Returns how many seconds elapsed since the given timestamp object.
```

```
@param (string) n
```

```
@usage
(timestamp-object->elapsed-s #<DateTime 2020-04-20T16:20:00.123Z>)
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->elapsed-s
  [n]
  (let [epoch-ms (epoch/epoch-ms)]
       (->> n epoch/timestamp-object->epoch-ms (- epoch-ms) convert/ms->s)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object->elapsed-s]]))

(time.api/timestamp-object->elapsed-s ...)
(timestamp-object->elapsed-s          ...)
```

</details>

---

### timestamp-object->epoch-ms

```
@description
Converts the given timestamp object to epoch milliseconds.
```

```
@param (string) n
```

```
@example
(timestamp-object->epoch-ms #<DateTime 2021-12-29T18:01:00.000+02:00>)
=>
1640800860000
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->epoch-ms
  [n]
  #?(:clj (if n (-> n str clj-time.coerce/to-epoch convert/s->ms))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object->epoch-ms]]))

(time.api/timestamp-object->epoch-ms ...)
(timestamp-object->epoch-ms          ...)
```

</details>

---

### timestamp-object->epoch-s

```
@description
Converts the given timestamp object to epoch seconds.
```

```
@param (string) n
```

```
@example
(timestamp-object->epoch-s #<DateTime 2021-12-29T18:01:00.000+02:00>)
=>
1640800860
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->epoch-s
  [n]
  #?(:clj (if n (-> n str clj-time.coerce/to-epoch))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object->epoch-s]]))

(time.api/timestamp-object->epoch-s ...)
(timestamp-object->epoch-s          ...)
```

</details>

---

### timestamp-object->hours

```
@description
Converts the given timestamp object to hours.
```

```
@param (object) n
```

```
@example
(timestamp-object->hours #<DateTime 2020-04-20T16:20:00.123Z>)
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
  #?(:clj  (clj-time.core/hours n)
     :cljs (cljs-time.core/hour n)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object->hours]]))

(time.api/timestamp-object->hours ...)
(timestamp-object->hours          ...)
```

</details>

---

### timestamp-object->milliseconds

```
@description
Converts the given timestamp object to milliseconds.
```

```
@param (object) n
```

```
@example
(timestamp-object->milliseconds #<DateTime 2020-04-20T16:20:00.123Z>)
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
  #?(:clj  (clj-time.core/milli  n)
     :cljs (cljs-time.core/milli n)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object->milliseconds]]))

(time.api/timestamp-object->milliseconds ...)
(timestamp-object->milliseconds          ...)
```

</details>

---

### timestamp-object->minutes

```
@description
Converts the given timestamp object to minutes.
```

```
@param (object) n
```

```
@example
(timestamp-object->minutes #<DateTime 2020-04-20T16:20:00.123Z>)
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
  #?(:clj  (clj-time.core/minutes n)
     :cljs (cljs-time.core/minute n)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object->minutes]]))

(time.api/timestamp-object->minutes ...)
(timestamp-object->minutes          ...)
```

</details>

---

### timestamp-object->month

```
@description
Converts the given timestamp object to month.
```

```
@param (object) n
```

```
@example
(timestamp-object->month #<DateTime 2020-04-20T16:20:00.123Z>)
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
  #?(:clj  (clj-time.core/month  n)
     :cljs (cljs-time.core/month n)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object->month]]))

(time.api/timestamp-object->month ...)
(timestamp-object->month          ...)
```

</details>

---

### timestamp-object->seconds

```
@description
Converts the given timestamp object to seconds.
```

```
@param (object) n
```

```
@example
(timestamp-object->seconds #<DateTime 2020-04-20T16:20:00.123Z>)
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
  #?(:clj  (clj-time.core/seconds n)
     :cljs (cljs-time.core/sec    n)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object->seconds]]))

(time.api/timestamp-object->seconds ...)
(timestamp-object->seconds          ...)
```

</details>

---

### timestamp-object->week

```
@description
Converts the given timestamp object to week.
```

```
@param (object) n
```

```
@example
(timestamp-object->week #<DateTime 2020-04-20T16:20:00.123Z>)
=>
4
```

```
@return (W)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object->week
  [n]
  #?(:clj  (clj-time.core/week-number-of-year  n)
     :cljs (cljs-time.core/week-number-of-year n)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object->week]]))

(time.api/timestamp-object->week ...)
(timestamp-object->week          ...)
```

</details>

---

### timestamp-object->year

```
@description
Converts the given timestamp object to year.
```

```
@param (object) n
```

```
@example
(timestamp-object->year #<DateTime 2020-04-20T16:20:00.123Z>)
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
  #?(:clj  (clj-time.core/year  n)
     :cljs (cljs-time.core/year n)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object->year]]))

(time.api/timestamp-object->year ...)
(timestamp-object->year          ...)
```

</details>

---

### timestamp-object?

```
@description
Returns TRUE if the given 'n' value is a timestamp object.
```

```
@param (*) n
```

```
@example
(timestamp-object? #<DateTime 2020-04-20T16:20:00.123+02:00>)
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-object?
  [n]
  #?(:clj (let [type (type n)]
               (= type org.joda.time.DateTime))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-object?]]))

(time.api/timestamp-object? ...)
(timestamp-object?          ...)
```

</details>

---

### timestamp-string

```
@description
Returns a timestamp string.
```

```
@param (string)(opt) time-zone
```

```
@example
(timestamp-string)
=>
"2020-04-20T16:20:00.123Z"
```

```
@example
(timestamp-string "Europe/Budapest")
=>
"2020-04-20T16:20:00.123+02:00"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string
  ([]
   #?(:clj  (let [timestamp-object (timestamp-object)]
                 (str timestamp-object))
      :cljs (let [formatter (cljs-time.format/formatter "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                  timestamp (cljs-time.core/now)]
                 (cljs-time.format/unparse formatter timestamp))))

  ([time-zone]
   #?(:clj (let [timestamp-object (timestamp-object time-zone)]
                (str timestamp-object)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-string]]))

(time.api/timestamp-string ...)
(timestamp-string          ...)
```

</details>

---

### timestamp-string->date

```
@description
Converts the given timestamp string to date string.
```

```
@param (string) n
@param (keyword)(opt) format
:mmdd, :yymmdd, :yyyymmdd
Default: :yyyymmdd
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
   (if (string/nonblank? n)
       (let [year                        (timestamp-string->year  n)
             month (format/leading-zeros (timestamp-string->month n) 2)
             day   (format/leading-zeros (timestamp-string->day   n) 2)]
            (case format :yyyymmdd (str year"-"month"-"day)
                         :yymmdd   (let [year (string/part year 2 4)]
                                        (str year"-"month"-"day))
                         :mmdd     (str month"-"day)
                         (-> n))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-string->date]]))

(time.api/timestamp-string->date ...)
(timestamp-string->date          ...)
```

</details>

---

### timestamp-string->date-time

```
@description
Converts the given timestamp string to date and time string.
```

```
@param (string) n
@param (keyword)(opt) date-format
:mmdd, :yymmdd, :yyyymmdd
Default: :yyyymmdd
@param (keyword)(opt) time-format
:hhmm, :hhmmss, :hhmmssmmm
Default: :hhmmss
```

```
@example
(timestamp-string->date-time "2020-04-20T16:20:00.123Z" :yyyymmdd :hhmmss)
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
   (if (string/nonblank? n)
       (let [date (timestamp-string->date n date-format)
             time (timestamp-string->time n time-format)]
            (str date" - "time)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-string->date-time]]))

(time.api/timestamp-string->date-time ...)
(timestamp-string->date-time          ...)
```

</details>

---

### timestamp-string->day

```
@description
Converts the given timestamp string to day.
```

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
(ns my-namespace (:require [time.api :refer [timestamp-string->day]]))

(time.api/timestamp-string->day ...)
(timestamp-string->day          ...)
```

</details>

---

### timestamp-string->elapsed-ms

```
@description
Returns how many milliseconds elapsed since the given timestamp string.
```

```
@param (string) n
```

```
@usage
(timestamp-string->elapsed-ms "2020-04-20T16:20:00.123Z")
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->elapsed-ms
  [n]
  (let [epoch-ms (epoch/epoch-ms)]
       (->> n epoch/timestamp-string->epoch-ms (- epoch-ms))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-string->elapsed-ms]]))

(time.api/timestamp-string->elapsed-ms ...)
(timestamp-string->elapsed-ms          ...)
```

</details>

---

### timestamp-string->elapsed-s

```
@description
Returns how many seconds elapsed since the given timestamp string.
```

```
@param (string) n
```

```
@usage
(timestamp-string->elapsed-s "2020-04-20T16:20:00.123Z")
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->elapsed-s
  [n]
  (let [epoch-ms (epoch/epoch-ms)]
       (->> n epoch/timestamp-string->epoch-ms (- epoch-ms) convert/ms->s)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-string->elapsed-s]]))

(time.api/timestamp-string->elapsed-s ...)
(timestamp-string->elapsed-s          ...)
```

</details>

---

### timestamp-string->epoch-ms

```
@description
Converts the given timestamp string to epoch milliseconds.
```

```
@param (string) n
```

```
@example
(timestamp-string->epoch-ms "2021-12-29T18:01:00.000Z")
=>
1640800860000
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->epoch-ms
  [n]
  #?(:clj (if n (-> n clj-time.coerce/to-epoch convert/s->ms))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-string->epoch-ms]]))

(time.api/timestamp-string->epoch-ms ...)
(timestamp-string->epoch-ms          ...)
```

</details>

---

### timestamp-string->epoch-s

```
@description
Converts the given timestamp string to epoch seconds.
```

```
@param (string) n
```

```
@example
(timestamp-string->epoch-s "2021-12-29T18:01:00.000Z")
=>
1640800860
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->epoch-s
  [n]
  #?(:clj (if n (-> n clj-time.coerce/to-epoch))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-string->epoch-s]]))

(time.api/timestamp-string->epoch-s ...)
(timestamp-string->epoch-s          ...)
```

</details>

---

### timestamp-string->hours

```
@description
Converts the given timestamp string to hours.
```

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
(ns my-namespace (:require [time.api :refer [timestamp-string->hours]]))

(time.api/timestamp-string->hours ...)
(timestamp-string->hours          ...)
```

</details>

---

### timestamp-string->milliseconds

```
@description
Converts the given timestamp string to milliseconds.
```

```
@param (string) n
```

```
@example
(timestamp-string->milliseconds "2020-04-20T16:20:00.123Z")
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
(ns my-namespace (:require [time.api :refer [timestamp-string->milliseconds]]))

(time.api/timestamp-string->milliseconds ...)
(timestamp-string->milliseconds          ...)
```

</details>

---

### timestamp-string->minutes

```
@description
Converts the given timestamp string to minutes.
```

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
(ns my-namespace (:require [time.api :refer [timestamp-string->minutes]]))

(time.api/timestamp-string->minutes ...)
(timestamp-string->minutes          ...)
```

</details>

---

### timestamp-string->month

```
@description
Converts the given timestamp string to month.
```

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
(ns my-namespace (:require [time.api :refer [timestamp-string->month]]))

(time.api/timestamp-string->month ...)
(timestamp-string->month          ...)
```

</details>

---

### timestamp-string->seconds

```
@description
Converts the given timestamp string to seconds.
```

```
@param (string) n
```

```
@example
(timestamp-string->seconds "2020-04-20T16:20:00.123Z")
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
(ns my-namespace (:require [time.api :refer [timestamp-string->seconds]]))

(time.api/timestamp-string->seconds ...)
(timestamp-string->seconds          ...)
```

</details>

---

### timestamp-string->time

```
@description
Converts the given timestamp string to time string.
```

```
@param (string) n
@param (keyword)(opt) format
:hhmm, :hhmmss, :hhmmssmmm
Default: :hhmmss
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
   (if (string/nonblank? n)
       (let [hours        (format/leading-zeros (timestamp-string->hours        n) 2)
             minutes      (format/leading-zeros (timestamp-string->minutes      n) 2)
             seconds      (format/leading-zeros (timestamp-string->seconds      n) 2)
             milliseconds (format/leading-zeros (timestamp-string->milliseconds n) 3)]
            (case format :hhmmssmmm (str hours":"minutes":"seconds"."milliseconds)
                         :hhmmss    (str hours":"minutes":"seconds)
                         :hhmm      (str hours":"minutes)
                         (-> n))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-string->time]]))

(time.api/timestamp-string->time ...)
(timestamp-string->time          ...)
```

</details>

---

### timestamp-string->today?

```
@description
Returns TRUE if the given timestamp string corresponds to the actual day.
```

```
@param (string) n
```

```
@example
(timestamp-string->today "2020-04-20T16:20:00.123Z")
=>
true
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
(ns my-namespace (:require [time.api :refer [timestamp-string->today?]]))

(time.api/timestamp-string->today? ...)
(timestamp-string->today?          ...)
```

</details>

---

### timestamp-string->week

```
@description
Converts the given timestamp string to week.
```

```
@param (string) n
```

```
@example
(timestamp-string->week "2020-04-20T16:20:00.123Z")
=>
"4"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn timestamp-string->week
  [n])
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [timestamp-string->week]]))

(time.api/timestamp-string->week ...)
(timestamp-string->week          ...)
```

</details>

---

### timestamp-string->year

```
@description
Converts the given timestamp string to year.
```

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
(ns my-namespace (:require [time.api :refer [timestamp-string->year]]))

(time.api/timestamp-string->year ...)
(timestamp-string->year          ...)
```

</details>

---

### timestamp-string?

```
@description
Returns TRUE if the given 'n' value is a timestamp string.
```

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
(ns my-namespace (:require [time.api :refer [timestamp-string?]]))

(time.api/timestamp-string? ...)
(timestamp-string?          ...)
```

</details>

---

### unparse-timestamp

```
@description
Converts the given timestamp object to timestamp string.
```

```
@param (object) n
```

```
@example
(unparse-timestamp #<DateTime 2020-04-20T16:20:00.123Z>)
=>
"2020-04-20T16:20:00.123"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn unparse-timestamp
  [n]
  #?(:clj (str n)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [unparse-timestamp]]))

(time.api/unparse-timestamp ...)
(unparse-timestamp          ...)
```

</details>

---

### unparse-timestamps

```
@description
Converts the timestamp objects in the given data structure to timestamp strings.
```

```
@param (*) n
```

```
@example
(unparse-timestamps {:my-timestamp #<DateTime 2020-04-20T16:20:00.123Z>})
=>
{:my-timestamp "2020-04-20T16:20:00.123Z"}
```

```
@return (*)
```

<details>
<summary>Source code</summary>

```
(defn unparse-timestamps
  [n]
  (cond (timestamp/timestamp-object? n) (unparse-timestamp n)
        (map?                        n) (map/->values      n unparse-timestamps)
        (vector?                     n) (vector/->items    n unparse-timestamps)
        :return n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [unparse-timestamps]]))

(time.api/unparse-timestamps ...)
(unparse-timestamps          ...)
```

</details>

---

<sub>This documentation is generated with the [clj-docs-generator](https://github.com/bithandshake/clj-docs-generator) engine.</sub>

