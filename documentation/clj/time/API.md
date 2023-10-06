
# time.api Clojure namespace

##### [README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > time.api

### Index

- [clear-interval!](#clear-interval)

- [current-date](#current-date)

- [current-day](#current-day)

- [current-hours](#current-hours)

- [current-millisecond](#current-millisecond)

- [current-minutes](#current-minutes)

- [current-month](#current-month)

- [current-seconds](#current-seconds)

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

- [epoch-s](#epoch-s)

- [epoch-s->timestamp-string](#epoch-s-timestamp-string)

- [h->D](#h-d)

- [h->W](#h-w)

- [h->m](#h-m)

- [h->ms](#h-ms)

- [h->s](#h-s)

- [hours-left-from-this-day](#hours-left-from-this-day)

- [m->D](#m-d)

- [m->W](#m-w)

- [m->h](#m-h)

- [m->ms](#m-ms)

- [m->s](#m-s)

- [milliseconds-left-from-this-minute](#milliseconds-left-from-this-minute)

- [milliseconds-left-from-this-second](#milliseconds-left-from-this-second)

- [minutes-left-from-this-hour](#minutes-left-from-this-hour)

- [ms->D](#ms-d)

- [ms->W](#ms-w)

- [ms->h](#ms-h)

- [ms->m](#ms-m)

- [ms->s](#ms-s)

- [ms->time](#ms-time)

- [parse-date](#parse-date)

- [parse-date-time](#parse-date-time)

- [parse-timestamp](#parse-timestamp)

- [reduce-interval](#reduce-interval)

- [s->D](#s-d)

- [s->W](#s-w)

- [s->h](#s-h)

- [s->m](#s-m)

- [s->ms](#s-ms)

- [seconds-left-from-this-minute](#seconds-left-from-this-minute)

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

- [unparse-date-time](#unparse-date-time)

- [unparse-timestamp](#unparse-timestamp)

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
  [interval-id])
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
@example
(current-date)
=>
"2020-04-20"
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

### current-hours

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
(ns my-namespace (:require [time.api :refer [current-hours]]))

(time.api/current-hours)
(current-hours)
```

</details>

---

### current-millisecond

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

### current-minutes

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
(ns my-namespace (:require [time.api :refer [current-minutes]]))

(time.api/current-minutes)
(current-minutes)
```

</details>

---

### current-month

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

### current-seconds

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
(ns my-namespace (:require [time.api :refer [current-seconds]]))

(time.api/current-seconds)
(current-seconds)
```

</details>

---

### current-year

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
Converts the given date to timestamp-string than converts the result to epoch-ms.
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
Returns true if the given epoch-ms is ...
... >= the first ms of the given date, and
... <= the last ms of the given date.
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
Returns true if the given epoch-ms is ...
... <= the last ms of the given date.
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
Returns true if the given epoch-ms is ...
... > the last ms of the given date.
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
Returns true if the given epoch-ms is ...
... < the first ms of the given date.
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
Returns true if the given epoch-ms is ...
... >= the first ms of the given date.
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
  [])
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
  (-> (clj-time.core/now)
      (clj-time.coerce/to-long)))
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
Converts the given epoch-ms to timestamp-string than converts the result to date.
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
  (if n (-> n clj-time.coerce/from-long str)))
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
  []
  (-> (clj-time.core/now)
      (clj-time.coerce/to-long)
      (quot 1000)))
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
  (if n (-> n convert/s->ms clj-time.coerce/from-long str)))
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
(ns my-namespace (:require [time.api :refer [h->D]]))

(time.api/h->D ...)
(h->D          ...)
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
(ns my-namespace (:require [time.api :refer [h->W]]))

(time.api/h->W ...)
(h->W          ...)
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
(ns my-namespace (:require [time.api :refer [h->m]]))

(time.api/h->m ...)
(h->m          ...)
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
(ns my-namespace (:require [time.api :refer [h->ms]]))

(time.api/h->ms ...)
(h->ms          ...)
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
(ns my-namespace (:require [time.api :refer [h->s]]))

(time.api/h->s ...)
(h->s          ...)
```

</details>

---

### hours-left-from-this-day

```
@usage
(hours-left-from-this-day)
```

```
@return (h)
```

<details>
<summary>Source code</summary>

```
(defn hours-left-from-this-day
  []
  (let [current-hour (current-hour)]
       (- 24 current-hour)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [hours-left-from-this-day]]))

(time.api/hours-left-from-this-day)
(hours-left-from-this-day)
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
(ns my-namespace (:require [time.api :refer [m->D]]))

(time.api/m->D ...)
(m->D          ...)
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
(ns my-namespace (:require [time.api :refer [m->W]]))

(time.api/m->W ...)
(m->W          ...)
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
(ns my-namespace (:require [time.api :refer [m->h]]))

(time.api/m->h ...)
(m->h          ...)
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
(ns my-namespace (:require [time.api :refer [m->ms]]))

(time.api/m->ms ...)
(m->ms          ...)
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
(ns my-namespace (:require [time.api :refer [m->s]]))

(time.api/m->s ...)
(m->s          ...)
```

</details>

---

### milliseconds-left-from-this-minute

```
@usage
(milliseconds-left-from-this-minute)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn milliseconds-left-from-this-minute
  []
  (let [seconds-left-from-this-minute (seconds-left-from-this-minute)]
       (* 1000 seconds-left-from-this-minute)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [milliseconds-left-from-this-minute]]))

(time.api/milliseconds-left-from-this-minute)
(milliseconds-left-from-this-minute)
```

</details>

---

### milliseconds-left-from-this-second

```
@usage
(milliseconds-left-from-this-second)
```

```
@return (ms)
```

<details>
<summary>Source code</summary>

```
(defn milliseconds-left-from-this-second
  []
  (let [current-millisecond (current-millisecond)]
       (- 1000 current-millisecond)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [milliseconds-left-from-this-second]]))

(time.api/milliseconds-left-from-this-second)
(milliseconds-left-from-this-second)
```

</details>

---

### minutes-left-from-this-hour

```
@usage
(minutes-left-from-this-hour)
```

```
@return (m)
```

<details>
<summary>Source code</summary>

```
(defn minutes-left-from-this-hour
  []
  (let [current-minute (current-minute)]
       (- 60 current-minute)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [minutes-left-from-this-hour]]))

(time.api/minutes-left-from-this-hour)
(minutes-left-from-this-hour)
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
(ns my-namespace (:require [time.api :refer [ms->D]]))

(time.api/ms->D ...)
(ms->D          ...)
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
(ns my-namespace (:require [time.api :refer [ms->W]]))

(time.api/ms->W ...)
(ms->W          ...)
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
(ns my-namespace (:require [time.api :refer [ms->h]]))

(time.api/ms->h ...)
(ms->h          ...)
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
(ns my-namespace (:require [time.api :refer [ms->m]]))

(time.api/ms->m ...)
(ms->m          ...)
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
(ns my-namespace (:require [time.api :refer [ms->s]]))

(time.api/ms->s ...)
(ms->s          ...)
```

</details>

---

### ms->time

```
@param (float, integer or string) n
@param (keyword)(opt) format
:hhmmssmmm, :hhmmss
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
(ns my-namespace (:require [time.api :refer [ms->time]]))

(time.api/ms->time ...)
(ms->time          ...)
```

</details>

---

### parse-date

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
  (try (let [formatter (clj-time.format/formatter "yyyy-MM-dd")]
            (clj-time.format/parse formatter n))
       (catch Exception e (println e))))
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

### parse-date-time

```
@param (*) n
```

```
@example
(parse-date-time {:my-timestamp "2020-04-20T16:20:00.123Z"})
=>
{:my-timestamp #<DateTime 2020-04-20T16:20:00.123Z>}
```

```
@return (*)
```

<details>
<summary>Source code</summary>

```
(defn parse-date-time
  [n]
  (cond (timestamp/date-string?      n) (parse-date      n)
        (timestamp/timestamp-string? n) (parse-timestamp n)
        (map?                        n) (map/->values    n parse-date-time)
        (vector?                     n) (vector/->items  n parse-date-time)
        :return n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [parse-date-time]]))

(time.api/parse-date-time ...)
(parse-date-time          ...)
```

</details>

---

### parse-timestamp

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
  (try (let [formatter (clj-time.format/formatters :date-time)]
            (clj-time.format/parse formatter n))
       (catch Exception e (println e))))
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
(ns my-namespace (:require [time.api :refer [reduce-interval]]))

(time.api/reduce-interval ...)
(reduce-interval          ...)
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
(ns my-namespace (:require [time.api :refer [s->D]]))

(time.api/s->D ...)
(s->D          ...)
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
(ns my-namespace (:require [time.api :refer [s->W]]))

(time.api/s->W ...)
(s->W          ...)
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
(ns my-namespace (:require [time.api :refer [s->h]]))

(time.api/s->h ...)
(s->h          ...)
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
(ns my-namespace (:require [time.api :refer [s->m]]))

(time.api/s->m ...)
(s->m          ...)
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
(ns my-namespace (:require [time.api :refer [s->ms]]))

(time.api/s->ms ...)
(s->ms          ...)
```

</details>

---

### seconds-left-from-this-minute

```
@usage
(seconds-left-from-this-minute)
```

```
@return (s)
```

<details>
<summary>Source code</summary>

```
(defn seconds-left-from-this-minute
  []
  (let [current-second (current-second)]
       (- 60 current-second)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [seconds-left-from-this-minute]]))

(time.api/seconds-left-from-this-minute)
(seconds-left-from-this-minute)
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
@return (tea_time.core.Every object)
```

<details>
<summary>Source code</summary>

```
(defn set-interval!
  [f interval]
  (tea-time.core/every! (convert/ms->s interval) 0 f))
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
@return (tea_time.core.Once object)
```

<details>
<summary>Source code</summary>

```
(defn set-timeout!
  [f timeout]
  (tea-time.core/after! (convert/ms->s timeout) f))
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
   (clj-time.core/now))

  ([time-zone]
   (let [timestamp (clj-time.core/now)
         time-zone (clj-time.core/time-zone-for-id time-zone)]
        (clj-time.core/to-time-zone timestamp time-zone))))
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
  (clj-time.core/day n))
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
  (if n (-> n str clj-time.coerce/to-epoch convert/s->ms)))
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
  (if n (-> n str clj-time.coerce/to-epoch)))
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
  (clj-time.core/hours n))
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
  (clj-time.core/milli n))
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
  (clj-time.core/minutes  n))
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
  (clj-time.core/month n))
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
  (clj-time.core/seconds n))
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
  (clj-time.core/week-number-of-year n))
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
  (clj-time.core/year n))
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
  (let [type (type n)]
       (= type org.joda.time.DateTime)))
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
   (let [timestamp-object (timestamp-object)]
        (str timestamp-object)))

  ([time-zone]
   (let [timestamp-object (timestamp-object time-zone)]
        (str timestamp-object))))
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
@param (string) n
@param (keyword)(opt) format
:yyyymmdd, :yymmdd
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
(ns my-namespace (:require [time.api :refer [timestamp-string->date]]))

(time.api/timestamp-string->date ...)
(timestamp-string->date          ...)
```

</details>

---

### timestamp-string->date-time

```
@param (string) n
@param (keyword)(opt) date-format
:yyyymmdd, :yymmdd
Default: :yyyymmdd
@param (keyword)(opt) time-format
:hhmmss, :hhmm
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
            (str date " - " time)))))
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
  (if n (-> n clj-time.coerce/to-epoch convert/s->ms)))
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
  (if n (-> n clj-time.coerce/to-epoch)))
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
@param (string) n
@param (keyword)(opt) format
:hhmmss, :hhmm
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
(ns my-namespace (:require [time.api :refer [timestamp-string->time]]))

(time.api/timestamp-string->time ...)
(timestamp-string->time          ...)
```

</details>

---

### timestamp-string->today?

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
  [n])
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
@param (string) n
```

```
@example
(timestamp-string->week "2020-04-20T16:20:00.123Z")
=>
"?"
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

### unparse-date-time

```
@param (*) n
```

```
@example
(unparse-date-time {:my-timestamp #<DateTime 2020-04-20T16:20:00.123Z>})
=>
{:my-timestamp "2020-04-20T16:20:00.123Z"}
```

```
@return (*)
```

<details>
<summary>Source code</summary>

```
(defn unparse-date-time
  [n]
  (cond (timestamp/timestamp-object? n) (unparse-timestamp n)
        (map?                        n) (map/->values      n unparse-date-time)
        (vector?                     n) (vector/->items    n unparse-date-time)
        :return n))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [time.api :refer [unparse-date-time]]))

(time.api/unparse-date-time ...)
(unparse-date-time          ...)
```

</details>

---

### unparse-timestamp

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
  (str n))
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

This documentation is generated with the [clj-docs-generator](https://github.com/bithandshake/clj-docs-generator) engine.

